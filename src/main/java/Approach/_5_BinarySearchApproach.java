package Approach;

import java.util.Arrays;

//O(log n)

public class _5_BinarySearchApproach {
    public static void main(String[] args) {

        int[] array = new int[100];
        int target = 42;

        //fill the array
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }


//      int index = Arrays.binarySearch(array, target);

        int index = binarySearch(array, target);
        if (index == -1) {
            System.out.println(target + " not found!");
        } else {
            System.out.println("Element found at: " + target);
        }

    }

    private static int binarySearch(int[] array, int target) {

        int low = 0;
        int height = array.length - 1;

        while (low <= height) {
            int middleIndex = low + (height - low) / 2;  //formula
            int value = array[middleIndex];

            System.out.println("middle: " + value);

            if (value < target) {
                low = middleIndex + 1;
            } else if (value > target) {
                height = middleIndex - 1;
            } else {
                return middleIndex;   //target is found
            }

        }


        return -1;    //target didn't find
    }
}
