package Problems._1_Easy;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */

public class _40_ValidPalindrome_125 {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        StringBuilder fixedString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                fixedString.append(c);
            }
        }
        fixedString = new StringBuilder(fixedString.toString().toLowerCase());

        int a_pointer = 0;
        int b_pointer = fixedString.length() - 1;

        while (a_pointer <= b_pointer) {
            if (fixedString.charAt(a_pointer) != fixedString.charAt(b_pointer)) {
                return false;
            }

            a_pointer++;
            b_pointer--;
        }

        return true;
    }
}
