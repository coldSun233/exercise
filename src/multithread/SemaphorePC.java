package multithread;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @author coldsun
 * 使用 Semaphore 实现生产者消费者
 */
public class SemaphorePC {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread p1 = new Thread(new Producer2(storage));
        Thread p2 = new Thread(new Producer2(storage));
        Thread p3 = new Thread(new Producer2(storage));

        Thread c1 = new Thread(new Consumer2(storage));
        Thread c2 = new Thread(new Consumer2(storage));
        Thread c3 = new Thread(new Consumer2(storage));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }

}

class Producer2 implements Runnable{
    private Storage storage;

    public Producer2(){}

    public Producer2(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run(){
        while(true){
            //Thread.sleep(1000);
            storage.produce();
        }
    }
}
class Consumer2 implements Runnable{
    private Storage storage;

    public Consumer2(){}

    public Consumer2(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                storage.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Storage {

    // 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<Object>();
    // 仓库的最大容量
    final Semaphore notFull = new Semaphore(10);
    // 将线程挂起，等待其他来触发
    final Semaphore notEmpty = new Semaphore(0);
    // 互斥锁
    final Semaphore mutex = new Semaphore(1);

    public void produce()
    {
        try {
            notFull.acquire();
            mutex.acquire();
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notEmpty.release();
        }
    }

    public void consume()
    {
        try {
            notEmpty.acquire();
            mutex.acquire();
            list.remove();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费一个产品，现库存" + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notFull.release();
        }
    }
}