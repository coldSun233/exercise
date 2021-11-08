package middle;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 将整数转换为罗马数字
 * 第12题 贪心算法
 */
public class IntToRoman {
    public static String solution(int num) {
        Map<String, Integer> dict = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();
        dict.put("M", 1000);
        dict.put("CM", 900);
        dict.put("D", 500);
        dict.put("CD", 400);
        dict.put("C", 100);
        dict.put("XC", 90);
        dict.put("L", 50);
        dict.put("XL", 40);
        dict.put("X", 10);
        dict.put("IX", 9);
        dict.put("V", 5);
        dict.put("IV", 4);
        dict.put("I", 1);
        for (String key : dict.keySet()) {
            while (num >= dict.get(key)) {
                result.append(key);
                num -= dict.get(key);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int n = 1024;
        System.out.println(solution(n));
    }
}
