package Problems.Easy;


import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * You can return the answer in any order.
 */

public class _9_TwoSum {
    public static void main(String[] args) {

        int[] array = {3, 2, 3};
        int target = 6;

        int[] result = twoSum(array, target);
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum(int[] array, int target) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }
}
