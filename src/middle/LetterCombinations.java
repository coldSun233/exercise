package middle;

import java.util.*;

/**
 * 第17题 电话号码的字母组合
 */
public class LetterCombinations {
    public static List<String> solution(String digits) {
        int len = digits.length();
        if (len <= 1) {
            return new ArrayList<>(Arrays.asList(getValue(digits)));
        }
        List<String> result = new ArrayList<>();
        List<String> left = solution(digits.substring(0, len/2));
        List<String> right = solution(digits.substring(len/2));
        for (String i : left) {
            for (String j : right) {
                result.add(i + j);
            }
        }
        return result;
    }

    private static String[] getValue(String  str) {
        switch (str) {
            case "2":
                return new String[]{"a", "b", "c"};
            case "3":
                return new String[]{"d", "e", "f"};
            case "4":
                return new String[]{"g", "h", "i"};
            case "5":
                return new String[]{"j", "k", "l"};
            case "6":
                return new String[]{"m", "n", "o"};
            case "7":
                return new String[]{"p", "q", "r", "s"};
            case "8":
                return new String[]{"t", "u", "v"};
            case "9":
                return new String[]{"w", "x", "y", "z"};
            default:
                return new String[]{};
        }
    }

    public static void main(String[] args) {
        String str = "23";
        System.out.println(solution(str));
    }
}
