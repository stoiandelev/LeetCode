package Problems._1_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */

public class PascalTriangleTwo {
    public static void main(String[] args) {

        int rowIndex = 3;
        System.out.println(getRow(rowIndex));


    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> PascalTriangle = new ArrayList<>();
        PascalTriangle.add(List.of(1));

        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> previousRow = PascalTriangle.get(i - 1);
            List<Integer> newRow = new LinkedList<>();
            newRow.add(1);


            for (int j = 0; j < previousRow.size() - 1; j++) {
                int numberToAdd = previousRow.get(j) + previousRow.get(j + 1);
                newRow.add(numberToAdd);
            }
            newRow.add(1);

            PascalTriangle.add(newRow);
        }


        return PascalTriangle.get(rowIndex);
    }
}
