package Problems._2_Medium;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 */

public class _12_GroupAnagrams_49 {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));

    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        // keep a table to group all the anagrams together
        Map<String, List<String>> map = new HashMap<>();

        for (String string : strs) {
            // sort the string to get the key
            String key = generateKey(string);

            // add the current string to the current table
            if (map.containsKey(key)) {
                map.get(key).add(string);
            } else {
                List<String> list = new ArrayList<>();
                list.add(string);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String generateKey(String string) {
        char[] arr = string.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
