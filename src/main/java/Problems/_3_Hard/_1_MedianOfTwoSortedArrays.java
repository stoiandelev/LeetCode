package Problems._3_Hard;


import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p></p>
 * The median is the middle number in a sorted list of numbers and
 * can be more descriptive of that data set than the average.
 * <p></p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 */


public class _1_MedianOfTwoSortedArrays {
    public static void main(String[] args) {

        int[] num1 = {1, 3};
        int[] num2 = {2};

        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);

        Arrays.sort(arr);

        if (arr.length % 2 != 0) {
            int mid = arr.length / 2;
            return (double) arr[mid];
        }

        int mid = arr.length / 2;
        return (double) (arr[mid - 1] + arr[mid]) / 2;


    }
}

