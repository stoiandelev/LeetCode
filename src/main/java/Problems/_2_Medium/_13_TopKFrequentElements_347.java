package Problems._2_Medium;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * Use bucket sort
 */

public class _13_TopKFrequentElements_347 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        // save each element's appearance in a table
        Map<Integer, Integer> bucket1 = new HashMap<>();
        for (int number : nums) {
            bucket1.put(number, bucket1.getOrDefault(number, 0) + 1);
        }

        // store each element's frequency as the key
        Map<Integer, List<Integer>> bucket2 = new HashMap<>();
        for (Integer number : bucket1.keySet()) {
            Integer elementFreq = bucket1.get(number);
            if (!bucket2.containsKey(elementFreq)) {
                bucket2.put(elementFreq, new ArrayList<>());
            }
            bucket2.get(elementFreq).add(number);
        }

        // get top K element
        int[] result = new int[k];
        for (int n = nums.length; n > 0; n--) {
            if (bucket2.containsKey(n)) {
                List<Integer> list = bucket2.get(n);
                for (Integer integer : list) {
                    result[--k] = integer;
                    if (k == 0) {
                        return result;
                    }
                }
            }

        }

        return result;

    }
}
