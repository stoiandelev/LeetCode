package Problems.Easy;



/**
 * Given an integer array nums and an integer val,
 * remove all occurrences of val in nums in-place.
 * The order of the elements may be changed.
 * Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k,
 * to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain
 * the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */

public class _15_RemoveAllOccurrencesInArray {
    public static void main(String[] args) {

        int[] array = new int[]{0,1,2,2,3,0,4,2};
        int value = 2;

        System.out.println(removeElement(array, value));


    }

    public static int removeElement(int[] array, int value) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != value) {
                array[index] = array[i];
                index++;
            }
        }
        return index;
    }
}
