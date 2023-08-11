package Problems._2_Medium;


/**
 * Given a string s, return the longest palindromic substring in s.
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Input: s = "cbbd"
 * Output: "bb"
 */

public class _3_LongestPalindromicSubstring {
    public static void main(String[] args) {

        String word = "cbbd";
        System.out.println(longestPalindrome(word));

    }

    static int maxLen = 0;
    static int lo = 0;

    public static String longestPalindrome(String word) {
        char[] input = word.toCharArray();
        if (word.length() < 2) {
            return word;
        }

        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i + 1);
        }
        return word.substring(lo, lo + maxLen);
    }

    public static void expandPalindrome(char[] word, int j, int k) {
        while (j >= 0 && k < word.length && word[j] == word[k]) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j + 1;
        }
    }
}
