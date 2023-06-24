package Problems.Easy;

import java.util.Arrays;

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
