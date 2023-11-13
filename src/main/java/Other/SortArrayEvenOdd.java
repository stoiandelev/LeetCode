package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * In an array, we can swap the elements at any two indices in a single operation called a move.
 * For example, if our array is a = [17, 4, 8], we can
 * swap a[0] = 17 and a[2] = 8 to get a = [8, 4, 17]
 * in a single move. We want to custom-sort an array such that
 * all the even elements are at the beginning of the array and
 * all the odd elements are at the end of the array.
 */

public class SortArrayEvenOdd {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(11);

//        Comparator<Integer> customComparator = (a, b) -> {
//            if (a % 2 == 0 && b % 2 != 0) {
//                return -1; // Even comes before odd
//            } else if (a % 2 != 0 && b % 2 == 0) {
//                return 1;  // Odd comes after even
//            } else {
//                return a - b; // Maintain relative order for even and odd numbers
//            }
//        };
//
//
//        // Sort the list using the custom comparator
//        list.sort(customComparator);
//
//        // Print the sorted list
//        for (int num : list) {
//            System.out.print(num + " ");
//        }

//        _1_List<Integer> evenList = new ArrayList<>();
//        _1_List<Integer> oddList = new ArrayList<>();
//
//        // Separate even and odd numbers
//        for (int num : list) {
//            if (num % 2 == 0) {
//                evenList.add(num);
//            } else {
//                oddList.add(num);
//            }
//        }
//
//        // Combine the lists (even numbers first, followed by odd numbers)
//        evenList.addAll(oddList);
//
//        // Update the original list with the custom-sorted elements
//        list.clear();
//        list.addAll(evenList);
//
//        // Print the sorted list
//        for (int num : list) {
//            System.out.print(num + " ");
//        }

        sortEvenOdd(list);

        System.out.println(list);


    }

    public static void sortEvenOdd(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            while (list.get(left) % 2 == 0 && left < right) {
                left++;
            }

            while (list.get(right) % 2 != 0 && left < right) {
                right--;
            }

            if (left < right) {
                // Swap the even and odd elements
                int temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
            }
        }
    }
}
