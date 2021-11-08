package middle;

/**
 * 两个字符串的最大公共子串
 * 动态规划
 */
public class longestCommonSubstring {

    public static String solution(String s1, String s2) { // 动态规划求解
        int len1 = s1.length();
        int len2 = s2.length();
        int max = 0;
        int end = 0;

        // 空间复杂度为O(n^2)
        //int[][] arr = new int[len1][len2];
        //for (int i = 0; i < len1; i++) {
        //    for (int j = 0; j < len2; j++) {
        //        if (s1.charAt(i) == s2.charAt(j)) {
        //            if (i ==0 || j ==0) {
        //                arr[i][j] = 1;
        //            } else {
        //                arr[i][j] = arr[i-1][j-1] + 1;
        //            }
        //            if (arr[i][j] > max) {
        //                max = arr[i][j];
        //                end = i;
        //            }
        //        }
        //    }
        //}

        //arr[i+1]可以由arr[i]推导出所以 空间复杂度可以降为O(n)
        int[] list = new int[len2];
        for (int i = 0; i < len1; i++) {
            for (int j = len2 - 1; j >= 0; j--) {
                // list[j]可能会用到list[j-1]的值所以list[j-1]不能比list[j]先更新
                // 采用从后向前的方式更新
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i ==0 || j ==0) {
                        list[j] = 1;
                    } else {
                        list[j] = list[j-1] + 1;
                    }
                    if (list[j] > max) {
                        max = list[j];
                        end = i;
                    }
                } else { // 二维数组使用不同的行不用置0，但一维数组需要
                    list[j] = 0;
                }

            }
        }

        return s1.substring(end-max+1, end+1);
    }

    public static void main(String[] args) {
        String s1 = "ababcabcd";
        String s2 = "abcdababca";
        System.out.println(solution(s1, s2));
    }
}
