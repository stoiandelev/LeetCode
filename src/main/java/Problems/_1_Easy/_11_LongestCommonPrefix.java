package Problems._1_Easy;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string ""
 */


public class _11_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        String result = longestCommonPrefix(strings);
        System.out.println(result);

    }

    public static String longestCommonPrefix(String[] strings) {
        Arrays.sort(strings);
        String string1 = strings[0];
        String string2 = strings[strings.length - 1];
        int index = 0;
        while (index < string1.length() && index < string2.length()) {
            if (string1.charAt(index) == string2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return string1.substring(0, index);
    }


}
