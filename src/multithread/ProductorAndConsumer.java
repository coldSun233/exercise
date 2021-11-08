package multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.*;

public class ProductorAndConsumer {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Thread p1 = new Thread(new Producer(repository));
        Thread p2 = new Thread(new Producer(repository));
        Thread p3 = new Thread(new Producer(repository));
        Thread c1 = new Thread(new Consumer(repository));
        Thread c2 = new Thread(new Consumer(repository));
        Thread c3 = new Thread(new Consumer(repository));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}

class Producer implements Runnable {
    Repository repository;
    public Producer(){}
    public Producer(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            try{
                Thread.sleep(500);
                repository.produce();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Repository repository;
    public Consumer(){}
    public Consumer(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            try{
                Thread.sleep(1000);
                repository.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Repository {

    // 仓库最大存储量
    private final int MAX_SIZE = 10;
    // 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<>();
    // 锁
    private final Lock lock = new ReentrantLock();
    // 仓库满的条件变量
    private final Condition full = lock.newCondition();
    // 仓库空的条件变量
    private final Condition empty = lock.newCondition();

    public void produce()
    {
        // 获得锁
        lock.lock();
        try {
            // 这里使用while是为了使得多个生产者
            while (list.size() == MAX_SIZE) {
                System.out.println("【生产者" + Thread.currentThread().getName()
                        + "】仓库已满");
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());

            empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume()
    {
        // 获得锁
        lock.lock();
        try {
            while (list.size() == 0) {
                System.out.println("【消费者" + Thread.currentThread().getName()
                        + "】仓库为空");
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费一个产品，现库存" + list.size());

            full.signalAll();
        } finally {
            lock.unlock();
        }

    }
}
