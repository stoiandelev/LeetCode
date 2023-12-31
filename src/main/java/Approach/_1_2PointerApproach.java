package Approach;

import java.util.Arrays;

/**
 * Whenever an array question deals with finding two numbers in an array
 * that satisfy a certain condition, either directly or indirectly,
 * two-pointer should be the first strategy that comes to mind.
 * Two sums find two numbers how give a target, return the position of the numbers.
 * Two pointers is really an easy and effective technique that is
 * typically used for searching pairs in a sorted array
 */

public class _1_2PointerApproach {

    public static void main(String[] args) {

        int[] number = {2, 7, 11, 15, 6, 7};
        int target = 18;

        System.out.println(Arrays.toString(twoSum(number, target)));

    }

    public static int[] twoSum(int[] numbers, int target) {
        // base case if the array is empty

        // define points
        int L = 0;
        int n = numbers.length;
        int R = n - 1;

        // two pointers find the sum
        while (L < R) {
            int sum = numbers[L] + numbers[R];
            if (sum == target) {
                return new int[]{L + 1, R + 1};
            } else if (sum < target) {  //move a left pointer by one -> to right
                L++;
            } else { // move a right pointer by one -> to left
                R--;
            }
        }
        return new int[]{-1 - 1};
    }
}
