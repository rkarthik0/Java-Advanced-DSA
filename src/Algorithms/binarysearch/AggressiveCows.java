/**
 * ============================================================
 * Problem            : Aggressive Cows
 * Created By         : Karthik R
 *
 * Approach           : Binary Search on Answer
 * Algorithm          : Sorting + Greedy + Binary Search
 *
 * Time Complexity    : O(N log N + N log(maxDistance))
 * Space Complexity   : O(1) excluding sorting space
 *
 * Idea:
 * - Sort the stalls.
 * - Binary search the minimum distance between cows.
 * - For a candidate distance m, greedily place each cow
 *   at the earliest possible stall.
 * - If B cows can be placed, m is possible.
 * - Try a larger distance.
 * ============================================================
 */

public class AggressiveCows {

    // Checks whether B cows can be placed
    // with at least m distance between consecutive cows.
    public boolean check(int[] A, int m, int B) {

        int cows = 1;

        // First cow is placed at the first stall.
        int last = 0;

        for (int i = 1; i < A.length; i++) {

            // Current stall is far enough from
            // the last placed cow.
            if (A[i] - A[last] >= m) {

                last = i;
                cows++;
            }

            // Successfully placed all cows.
            if (cows == B) {
                return true;
            }
        }

        return false;
    }

    public int solve(int[] A, int B) {

        // Sort stalls so we can greedily place cows.
        Arrays.sort(A);

        int n = A.length;

        // Minimum possible distance.
        int l = 1;

        // Maximum possible distance.
        int r = A[n - 1] - A[0];

        int ans = 0;

        // Binary search for maximum possible minimum distance.
        while (l <= r) {

            int m = l + (r - l) / 2;

            if (check(A, m, B)) {

                // m is possible.
                // Try to find an even larger distance.
                ans = m;
                l = m + 1;

            } else {

                // m is not possible.
                // Need a smaller distance.
                r = m - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        AggressiveCows obj =
                new AggressiveCows();

        int[] A = {1, 2, 4, 8, 9};
        int B = 3;

        System.out.println(obj.solve(A, B));
    }
}