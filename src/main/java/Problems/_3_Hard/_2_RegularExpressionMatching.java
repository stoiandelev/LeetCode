package Problems._3_Hard;

/**
 * Given an input string s and a pattern p,
 * implement regular expression matching with support for '.' And '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */


public class _2_RegularExpressionMatching {
    public static void main(String[] args) {

        String text = "aa";
        String pattern = "a";

        System.out.println(isMatch(text, pattern));

    }

    static Result[][] memo;


    enum Result {
        TRUE, FALSE
    }

    public static boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }


    public static boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean answer;
        if (j == pattern.length()) {
            answer = i == text.length();
        } else {
            boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i)
                    || pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                answer = (dp(i, j + 2, text, pattern)
                        || first_match && dp(i + 1, j, text, pattern));
            } else {
                answer = first_match && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = answer ? Result.TRUE : Result.FALSE;
        return answer;
    }
}
