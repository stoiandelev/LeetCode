package ChallengesForNewUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * You are given an m x n binary matrix mat of 1's (representing soldiers)
 * and 0's (representing civilians).
 * The soldiers are positioned in front of the civilians.
 * That is, all the 1's will appear to the left of all the 0's in each row.
 * In A row i is weaker than a row j if one of the following is true:
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 */

public class _6_TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {

        // Reading input and filling the matrix
        // for (int i = 0; i < matrix.length; i++) {
        //    for (int j = 0; j < matrix[i].length; j++) {
        //        matrix[i][j] = scanner.nextInt();
        //    }
        //}

        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };

        int kWeakness = 3;

        int[] answer = kWeakestRows(matrix, kWeakness);
        System.out.println(Arrays.toString(answer));


    }


    public static int[] kWeakestRows(int[][] matrix, int kWeakness) {

        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[kWeakness];

        for (int i = 0; i < matrix.length; i++) {
            list.add(noOfSoldiers(matrix[i]));
        }

        for (int i = 0; i < kWeakness; i++) {
            int index = list.indexOf(Collections.min(list));
            answer[i] = index;
            list.set(index, Integer.MAX_VALUE);
        }

        return answer;
    }


    public static int noOfSoldiers(int[] matrix) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == 1)
                count++;
        }
        return count;
    }
}

