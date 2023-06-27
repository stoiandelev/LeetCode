package Problems.Easy;

import java.util.Arrays;

/**
 * Given a string s consisting of words and spaces,
 * return the length of the last word in the string.
 * A word is a maximal
 * substring
 * consisting of non-space characters only.
 */

public class _18_LengthOfLastWord {
    public static void main(String[] args) {

        String input = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(input));

    }

    public static int lengthOfLastWord(String s) {
        String trimmedString = Arrays.toString(s.split("\\s+"));

        StringBuilder sb = new StringBuilder();
        for (int i = trimmedString.length() - 1; i >= 0; i--) {
            char currentChar = trimmedString.charAt(i);
            boolean word = Character.isLetter(currentChar);
            if (word) {
                sb.append(currentChar);
            } else if (currentChar == ']') {
                continue;
            } else {
                break;
            }
        }
        return sb.toString().length();
    }
}
