package ChallengesForNewUsers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 */


public class _4_FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(5));
        }


    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int number = 1; number <= n; number++) {

            boolean divisibleBy3 = (number % 3 == 0);
            boolean divisibleBy5 = (number % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                answer.add("FizzBuzz");
            } else if (divisibleBy3) {
                answer.add("Fizz");
            } else if (divisibleBy5) {
                answer.add("Buzz");
            } else {
                answer.add(Integer.toString(number));
            }
        }
        return answer;
    }
}
