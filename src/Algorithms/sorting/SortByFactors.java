/**
 * ============================================================
 * Problem            : Sort by Number of Factors
 * Created By         : Karthik R
 *
 * Approach           : Custom Sorting + Factor Counting
 * Algorithm          : Comparator
 *
 * Time Complexity    : O(N log N * sqrt(M))
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Count the number of factors of every number.
 * - Sort primarily by number of factors.
 * - If two numbers have the same number of factors,
 *   sort them by their actual value.
 * ============================================================
 */

import java.util.*;

public class SortByFactors {

    // Count number of factors of n
    private int countFactors(int n) {

        int count = 0;

        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {

                // i is a factor
                count++;

                // n / i is the paired factor
                if (i != n / i) {
                    count++;
                }
            }
        }

        return count;
    }

    public int[] solve(int[] A) {

        int n = A.length;

        // Convert int[] to Integer[]
        // because Arrays.sort() with a custom
        // Comparator works with objects.
        Integer[] temp = new Integer[n];

        for (int i = 0; i < n; i++) {
            temp[i] = A[i];
        }

        // Sort by:
        // 1. Number of factors
        // 2. Value if factor count is equal
        Arrays.sort(temp, new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {

                int f1 = countFactors(a);
                int f2 = countFactors(b);

                // Fewer factors come first
                if (f1 != f2) {
                    return Integer.compare(f1, f2);
                }

                // If factor count is same,
                // smaller number comes first
                return Integer.compare(a, b);
            }
        });

        // Copy sorted values back to A
        for (int i = 0; i < n; i++) {
            A[i] = temp[i];
        }

        return A;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        SortByFactors obj = new SortByFactors();

        int[] A = {12, 6, 8, 4, 3};

        int[] result = obj.solve(A);

        System.out.println(Arrays.toString(result));
    }
}