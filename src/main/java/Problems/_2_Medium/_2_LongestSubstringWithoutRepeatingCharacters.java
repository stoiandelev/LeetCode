package Problems._2_Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

public class _2_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String name = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(name));
    }

    public static int lengthOfLongestSubstring(String word) {
        int n = word.length();
        int maxLength = 0;

        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(word.charAt(right))) {
                charSet.add(word.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(word.charAt(right))) {
                    charSet.remove(word.charAt(left));
                    left++;
                }
                charSet.add(word.charAt(right));
            }
        }
        return maxLength;
    }
}
