package Problems._2_Medium;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * Set is used to prevent duplicate triplets, and parallelly
 * we will use two pointer approach to maintain J and k.
 */

public class _10_3SumClosest {
    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(threeSumClosest(nums, target));

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        // Initialize the closest sum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];


        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    // Update the closest sum if the current sum is closer to the target
                    closestSum = sum;
                }

                if (sum < target) {
                    j++; // Increment j to increase the sum
                } else {
                    k--; // Decrement k to decrease the sum
                }
            }
        }
        return closestSum;
    }
}
