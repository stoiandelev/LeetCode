package ChallengesForNewUsers;

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 * In one step, if the current number is even, you have to divide it by 2,
 * otherwise, you have to subtract 1 from it.
 */

public class _7_NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {

        int number = 14;
        System.out.println(numberOfSteps(number));

    }

    public static int numberOfSteps(int num) {
        int stepsToNumberToZero = 0;

        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
                stepsToNumberToZero++;
                continue;
            }

            num = num - 1;
            stepsToNumberToZero++;
        }
        return stepsToNumberToZero;

    }
}
