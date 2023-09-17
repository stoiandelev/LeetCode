package Problems._2_Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons)
 * is given below. Note that 1 does not map to any letters.
 */

public class _11_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {

        String digit = "23";
        System.out.println(letterCombinations(digit));

    }

    private static Map<Character, String> digitToLetters = new HashMap<>();
    private static List<String> resultList = new ArrayList<>();


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty() || digits.trim().isEmpty()) {
            return resultList;
        }

        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        generateCombinations(digits, 0, new StringBuilder());

        return resultList;
    }

    private static void generateCombinations(String digits, int currentIndex, StringBuilder currentCombination) {

        if (currentIndex == digits.length()) {
            resultList.add(currentCombination.toString());
            return;
        }

        char currentDigit = digits.charAt(currentIndex);
        String letterOption = digitToLetters.get(currentDigit);

        if (letterOption != null) {
            for (int i = 0; i < letterOption.length(); i++) {
                char letter = letterOption.charAt(i);
                currentCombination.append(letter);

                generateCombinations(digits, currentIndex + 1, currentCombination);

                currentCombination.deleteCharAt(currentCombination.length() - 1);
            }
        }

    }

}
