package easy;

import com.sun.javafx.sg.prism.web.NGWebView;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author coldsun
 */
public class Employee {
    public String name;
    public Employee() {
        name = "";
    }
    public Employee(String name) {
        this.name = name;
    }
}

class Manager extends Employee {
    public int bonus;
    public Manager() {
        super();
        bonus = 0;
    }
    public Manager(String name, int bouns) {
        super(name);
        this.bonus = bouns;
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> n = Arrays.asList(1, 2, 3);
        System.out.println(n);
    }
}