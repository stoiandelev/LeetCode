package Problems._2_Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */

public class _16_LongestConsecutiveSequence_128 {

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {
        int longestLength = 0;

        Map<Integer, Boolean> exploreMap = new HashMap<>();
        for (int num : nums) {
            exploreMap.put(num, Boolean.FALSE);
        }

        for (int num : nums) {
            int currentLength = 1;

            // check in forward direction
            int nextNumber = num + 1;
            while (exploreMap.containsKey(nextNumber) && exploreMap.get(nextNumber) == false) {
                currentLength++;
                exploreMap.put(nextNumber, Boolean.TRUE);

                // move to the next number
                nextNumber++;
            }

            // check in reverse direction
            int previousNumber = num - 1;
            while (exploreMap.containsKey(previousNumber) && exploreMap.get(previousNumber) == false) {
                currentLength++;
                exploreMap.put(previousNumber, Boolean.TRUE);

                // move to the previous number
                previousNumber--;
            }

            longestLength = Math.max(longestLength, currentLength);

        }


        return longestLength;
    }
}
