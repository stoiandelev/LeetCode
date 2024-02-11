package Problems._2_Medium;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such
 * that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */

public class _14_ProductOfArrayExceptSelf_238 {

    public static void main(String[] args) {

        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));


    }

    public static int[] productExceptSelf(int[] nums) {

        int N = nums.length;
        int[] result = new int[N];

        result[0] = 1;
        for (int i = 1; i < N; i++) {
            int firstNumber = nums[i - 1];
            int secondNumber = result[i - 1];
            result[i] = firstNumber * secondNumber;
        }

        int R = 1;
        int lastNumber = N - 1;
        for (int i = lastNumber; i >= 0; i--) {
            int currentNumber = result[i] * R;
            result[i] = currentNumber;
            R = R * nums[i];
        }

        return result;

    }
}
