package ChallengesForNewUsers;

public class _1_RomanToInteger {

    //Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    //Symbol Value
    //I 1
    //V 5
    //X 10
    //L 50
    //C 100
    //D 500
    //M 1000

    /**
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII.
     * Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX.
     * There are six instances where subtraction is used:
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     */

    //MCMXCIV
    //LVIII

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int answer = 0;
        int number = 0;
        int previous = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < previous) {
                answer -= number;
            } else {
                answer += number;
            }

            previous = number;
        }
        return answer;

    }
}
