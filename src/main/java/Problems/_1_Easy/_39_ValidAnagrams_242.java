package Problems._1_Easy;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original letters exactly once.
 */

public class _39_ValidAnagrams_242 {

    public static void main(String[] args) {

        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s, t));

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 26 char count have alphabet
        int[] char_counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }

        for (int count : char_counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }
}
