package Problems.Easy;

/**
 * Given two strings needle and haystack,
 * return the index of the first occurrence of needle in haystack,
 * or -1 if the needle is not part of haystack.
 */

public class _16_FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String word = "leetcode";
        String searchWord = "leeto";

        System.out.println(strStr(word, searchWord));
    }

    public static int strStr(String word, String searchWord) {
        int wordLength = word.length();
        int searchWordLength = searchWord.length();
        if (wordLength < searchWordLength)
            return -1;

        for (int i = 0; i <= word.length() - searchWord.length(); i++) {

            int j = 0;
            while (j < searchWord.length() && word.charAt(i + j) == searchWord.charAt(j)) {
                j++;
                if (j == searchWord.length()) {
                    return i;
                }
            }

        }
        return -1;
    }
}
