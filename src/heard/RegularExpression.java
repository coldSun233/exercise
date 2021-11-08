package heard;

/**
 * 第10题 正则表达式匹配
 * 动态规划
 * @author coldsun
 */
enum Result {TRUE, FALSE}

public class RegularExpression {
    //public static boolean solution(String s, String p) {
    //    if (p.isEmpty()) {
    //        return s.isEmpty();
    //    }
    //    boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
    //    if (p.length() > 1 && p.charAt(1) == '*') {
    //        return solution(s, p.substring(2)) || (firstMatch && solution(s.substring(1), p));
    //    } else {
    //        return firstMatch && solution(s.substring(1), p.substring(1));
    //    }
    //}


    // 动态规划
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean firstMatch = (i < text.length()
                    && (pattern.charAt(j) == text.charAt(i)
                        || pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        firstMatch && dp(i+1, j, text, pattern));
            } else {
                ans = firstMatch && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String p = ".*";
        System.out.println(new RegularExpression().isMatch(s, p));
    }
}
