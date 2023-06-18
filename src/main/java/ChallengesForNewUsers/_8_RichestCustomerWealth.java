package ChallengesForNewUsers;

/**
 * You are given an m x n integer grid accounts where accounts[i][j]
 * is the amount of money the ith customer has in
 * the jth bank. Return the wealth that the richest customer has.
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 */

import java.util.ArrayList;

/**
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 * Explanation:
 * 1st customer has wealth = 6
 * 2nd customers have wealth = 10
 * 3rd customers have wealth = 8
 * The 2nd customer is the richest with a wealth of 10.
 */

public class _8_RichestCustomerWealth {
    public static void main(String[] args) {

        //accounts == matrix
        int[][] matrix = {
                {2, 8, 7},
                {7, 1, 3},
                {1, 9, 5}
        };

        int result = maximumWealth(matrix);
        System.out.println(result);
    }

    public static int maximumWealth(int[][] accounts) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] account : accounts) {
            list.add(sumOfRowMatrix(account));
        }

        int maxSum = Integer.MIN_VALUE;
        for (Integer number : list) {
            if (number > maxSum) {
                maxSum = number;
            }
        }
        return maxSum;
    }

    public static int sumOfRowMatrix(int[] matrix) {
        int sum = 0;
        for (int i : matrix) {
            sum = sum + i;
        }
        return sum;
    }
}
