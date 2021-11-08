package middle;

/**
 * @author coldsun
 */

import java.sql.SQLOutput;

/**
 * 求字符串的最长回文
 */
public class LongestPalindrome {

    public static String solution1(String s) {
        /**
         * 将 s 倒转得到 s' 求 s s' 的最大公共子串
         */
        if (s.equals("")) {
            return "";
        }
        String s1 = s;
        String s2 = new StringBuffer(s).reverse().toString();
        int len = s.length();
        int max = 0;
        int end = 0;
        int[] list = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = len -1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        list[j] = 1;
                    } else {
                        list[j] = list[j-1] + 1;
                    }
                    if (list[j] > max) {
                        // 判断下标是否对应
                        int start = len - 1 -j;
                        if (start + list[j] -1 == i) {
                            max = list[j];
                            end = i;
                        }
                    }
                } else {
                    list[j] = 0;
                }
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }

    public static String solution2(String s) {
        /**
         * 扩展中心
         */
        int length = s.length();
        if (s == null || length < 1) {
            return "";
        }
        int max = 0;
        int end = 0;

        for (int i =0; i < 2 * length - 1; i++) {
            int len = expand(s, i);
            if (len > max) {
                max = len;
                end = i / 2 + len / 2;
            }
        }

        return s.substring(end - max + 1, end + 1);
    }

    public static int expand(String s, int center) {
        int left = center / 2;
        int right = left + center % 2;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left -1;
        // 减1是因为出循环的时候left--，right++，所以最终长度为(right-1)-(left+1)+1
    }

    public static String solution3(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                // j - i < 2 或 j - i < 3 都可以
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bababd";
        System.out.println(solution3(s));
    }
}
