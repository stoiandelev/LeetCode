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

        String word = "babad";
        System.out.println(longestPalindrome(word));

    }

    static int maxLength = 0;
    static int index = 0;

    public static String longestPalindrome(String word) {
        char[] input = word.toCharArray();
        if (word.length() < 2) {
            return word;
        }

        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i + 1);
        }
        return word.substring(index, index + maxLength);
    }

    public static void expandPalindrome(char[] word, int left, int right) {
        while (left >= 0 && right < word.length && word[left] == word[right]) {
            left--;
            right++;
        }
        if (maxLength < right - left - 1) {
            maxLength = right - left - 1;
            index = left + 1;
        }
    }
}

//public static void expandPalindrome(char[] word, int j, int k) {