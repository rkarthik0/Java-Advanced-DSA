/**
 * ============================================================
 * Problem            : Group Anagrams
 * Created By         : Karthik R
 *
 * Approach           : HashMap + Frequency Array
 * Algorithm          : Frequency Hashing
 *
 * Time Complexity    : O(N * K)
 * Space Complexity   : O(N * K)
 *
 * Idea:
 * - Two strings are anagrams if their character frequencies
 *   are exactly the same.
 * - Build a frequency array of 26 characters for every string.
 * - Convert that frequency array into a unique String key.
 * - Store strings having the same key in the same group.
 * ============================================================
 */

import java.util.*;

public class GroupAnagrams {

    public ArrayList<ArrayList<String>> groupAnagrams(
            ArrayList<String> A) {

        HashMap<String, ArrayList<String>> map =
                new HashMap<>();

        for (String str : A) {

            // Frequency of each lowercase character
            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            // Create unique key from frequency array
            StringBuilder sb = new StringBuilder();

            for (int count : freq) {
                sb.append('#').append(count);
            }

            String key = sb.toString();

            // Create group if key does not exist
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add string to its anagram group
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        GroupAnagrams obj = new GroupAnagrams();

        ArrayList<String> A = new ArrayList<>(
                Arrays.asList(
                        "eat",
                        "tea",
                        "tan",
                        "ate",
                        "nat",
                        "bat"
                )
        );

        ArrayList<ArrayList<String>> result =
                obj.groupAnagrams(A);

        System.out.println(result);
    }
}