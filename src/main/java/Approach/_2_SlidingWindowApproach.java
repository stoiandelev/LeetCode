package Approach;

/**
 * Minimum size Subarray Sum from how many minimum value can do sum grater or
 * equal given on target.
 * Minimum length;
 * Sliding Window Technique is mostly used for finding sub-arrays inside larger arrays.
 * You can apply the Sliding Window to a majority of
 * minimum/maximum/common subarray/substring type of questions.
 * Note that some subarray-related questions have very specific and optimized solutions,
 * like that of Kadane's Algorithm.
 * The condition to use the sliding window technique is that the problem
 * asks to find the maximum (or minimum) value for a function that
 * calculates the answer repeatedly for a set of ranges from the array.
 */

public class _2_SlidingWindowApproach {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1, 4, 4};
        int target = 7;

        System.out.println(minSubArrayLen(target, nums));


    }

    public static int minSubArrayLen(int target, int[] nums) {
        // base case if the array is empty

        // define pointers
        int L = 0;
        int R = 0;

        // min subArray length and sum
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int n = nums.length;

        // sliding a window to find min sub array length

        while (R < n) {
            // add the current element
            sum += nums[R];

            //contract window
            while (target <= sum) {
                min = Math.min(min, R - L + 1);
                sum -= nums[L];
                L++;
            }
            R++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
