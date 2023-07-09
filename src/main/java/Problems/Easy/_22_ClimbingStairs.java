package Problems.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */

public class _22_ClimbingStairs {
    public static void main(String[] args) {

        int stepsToReachTheTop = 4;
        System.out.println(climbStairs(stepsToReachTheTop));

    }

    public static int climbStairs(int stepsToReachTheTop) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(stepsToReachTheTop, memo);
    }

    private static int climbStairs(int stepsToReachTheTop, Map<Integer, Integer> memo) {
        if (stepsToReachTheTop == 0 || stepsToReachTheTop == 1) {
            return 1;
        }
        if (!memo.containsKey(stepsToReachTheTop)) {
            memo.put(stepsToReachTheTop, climbStairs(stepsToReachTheTop - 1, memo)
                    + climbStairs(stepsToReachTheTop - 2, memo));
        }
        return memo.get(stepsToReachTheTop);
    }
}


//    public static int climbStairs(int stepsToReachTheTop) {
//        if (stepsToReachTheTop == 0 || stepsToReachTheTop == 1) {
//            return 1;
//        }
//
//        int result1 = climbStairs(stepsToReachTheTop - 1);
//        int result2 = climbStairs(stepsToReachTheTop - 2);
//
//        int resultFinal = result1 + result2;
//
//        return resultFinal;
//    }

//    public static int climbStairs(int stepsToReachTheTop) {
//        if (stepsToReachTheTop == 0 || stepsToReachTheTop == 1) {
//            return 1;
//        }
//
//        return climbStairs(stepsToReachTheTop - 1)
//                + climbStairs(stepsToReachTheTop - 2);
//    }





