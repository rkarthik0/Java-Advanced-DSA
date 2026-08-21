/**
 * ============================================================
 * Problem            : Largest Number
 * Created By         : Karthik R
 *
 * Approach           : Greedy + Custom Sorting
 * Algorithm          : Comparator using Concatenation
 *
 * Time Complexity    : O(N log N * K)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Convert numbers to Integer[] because Arrays.sort()
 *   with a custom Comparator requires objects.
 * - For two numbers a and b, compare:
 *
 *       ab vs ba
 *
 * - If ba is larger, b should come before a.
 * - This ordering produces the largest possible number.
 * - If all numbers are zero, return "0".
 * ============================================================
 */

import java.util.*;

public class LargestNumber {

    public String largestNumber(int[] A) {

        int n = A.length;

        // Convert int[] to Integer[]
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = A[i];
        }

        // Custom comparator
        Arrays.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {

                String xy =
                        String.valueOf(a) +
                                String.valueOf(b);

                String yx =
                        String.valueOf(b) +
                                String.valueOf(a);

                // Larger concatenation comes first
                return yx.compareTo(xy);
            }
        });

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (int num : arr) {
            ans.append(num);
        }

        // Handle [0, 0, 0]
        if (ans.charAt(0) == '0') {
            return "0";
        }

        return ans.toString();
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        LargestNumber obj = new LargestNumber();

        int[] A = {3, 30, 34, 5, 9};

        System.out.println(
                obj.largestNumber(A)
        );
    }
}