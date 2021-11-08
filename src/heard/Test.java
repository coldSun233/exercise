package heard;


import javax.sound.midi.Soundbank;
import java.io.Console;
import java.util.*;

/**
 * @author coldsun
 */
public class Test {
    //public static int solution(String str) {
    //    String s = str.trim();
    //    if (s == null || s.length() < 1) {
    //        return 0;
    //    }
    //    if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+')
    //        return 0;
    //    char a;
    //    int result = 0;
    //    boolean negative = s.charAt(0) == '-';
    //    int i = Character.isDigit(s.charAt(0)) ? 0 : 1;
    //    for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
    //        a = s.charAt(i);
    //        if (Character.isDigit(a)) {
    //            if (negative && (result > Integer.MAX_VALUE / 10
    //                    || result == Integer.MAX_VALUE / 10 && a - '0' > 8)) {
    //                System.out.println('a');
    //                return Integer.MIN_VALUE;
    //            }
    //
    //            if (!negative && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && a - '0' > 7)) {
    //                System.out.println('a');
    //                return Integer.MAX_VALUE;
    //            }
    //
    //            result = 10 * result + a - '0';
    //            System.out.println(result);
    //        }
    //    }
    //    return negative ? -result : result;
    //}
    //
    //public static void main(String[] args) {
    //    int[] a = new int[10];
    //    System.out.println(a.length);
    //    System.out.println(solution("-2147483648"));
    //}
    protected String name;
    private String age;
    public Test() {}
    public Test(String name) {
        this.name = name;
    }
}

class Child extends Test {
    public Child() {}

    public void test(Test t) {
        System.out.println(t.name);
    }

    public void test2() {
        System.out.println();
    }

    public static void main(String[] args) {
        Test t = new Test("xiaoming");
        Child c = new Child();
        c.test(t);
    }
}
