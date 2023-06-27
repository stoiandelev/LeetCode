package Problems.Easy;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits,
 * where each digit[i] is the ith digit of the integer.
 * The digits are ordered from most significant to the least
 * significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */

public class _19_PlusOneInArray {
    public static void main(String[] args) {
        int[] array = {4,3,2,9};

        System.out.println(Arrays.toString(plusOne(array)));
    }

    public static int[] plusOne(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {

            if (array[i] < 9) {
                array[i]++;
                return array;
            }

            array[i] = 0;
        }

        array = new int[array.length + 1];
        array[0] = 1;
        return array;
    }

}
