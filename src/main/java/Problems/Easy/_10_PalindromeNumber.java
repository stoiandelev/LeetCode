package Problems.Easy;

/**
 * Given an integer x, return true if x is a palindrome and false otherwise.
 */

public class _10_PalindromeNumber {
    public static void main(String[] args) {
        int number = 121;
        System.out.println(isPalindrome(number));
    }

    public static boolean isPalindrome(int x) {
        String numberInString = String.valueOf(x); // Convert to String
        for (int i = 0; i < numberInString.length() / 2; i++) {
            if (numberInString.charAt(i) != numberInString.charAt(numberInString.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
