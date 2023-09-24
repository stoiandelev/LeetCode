package Problems._1_Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */

public class _33_PascalTriangle {
    public static void main(String[] args) {

        int numRows = 5;
        System.out.println(generatePascalTriangle(numRows));


    }

    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = triangle.get(i - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);

            for (int j = 1; j < previousRow.size(); j++) {
                int numberToAdd = previousRow.get(j - 1) + previousRow.get(j);
                newRow.add(numberToAdd);
            }

            newRow.add(1);
            triangle.add(newRow);
        }

        return triangle;

    }
}
