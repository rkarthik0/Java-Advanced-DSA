/**
 * ============================================================
 * Problem            : Painter's Partition Problem
 * Created By         : Karthik R
 *
 * Approach           : Binary Search on Answer
 * Algorithm          : Binary Search + Greedy
 *
 * Time Complexity    : O(N * log(S))
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Minimum possible time = maximum single board length.
 * - Maximum possible time = sum of all board lengths.
 * - Binary search for the minimum maximum workload.
 * - check() greedily assigns consecutive boards to painters.
 * ============================================================
 */

public class PaintersPartition {

    static final int MOD = 10000003;

    // Checks whether all boards can be painted
    // by A painters if one painter can paint at most m units.
    public boolean check(int[] C, int m, int A) {

        int painters = 1;
        int sum = 0;

        for (int i = 0; i < C.length; i++) {

            // Add current board to current painter.
            sum += C[i];

            // Current painter cannot handle this board.
            if (sum > m) {

                // Assign current board to next painter.
                painters++;

                sum = C[i];
            }

            // More painters are required than available.
            if (painters > A) {
                return false;
            }
        }

        return true;
    }

    public int paint(int A, int B, int[] C) {

        // l = minimum possible maximum workload
        // h = maximum possible maximum workload
        int l = 0;
        int h = 0;

        for (int board : C) {

            // One painter must paint this entire board.
            l = Math.max(l, board);

            // One painter could paint all boards.
            h += board;
        }

        long ans = h;

        // Binary search for minimum possible workload.
        while (l <= h) {

            int m = l + (h - l) / 2;

            if (check(C, m, A)) {

                // m is possible, try a smaller value.
                ans = m;
                h = m - 1;

            } else {

                // m is not possible, increase the limit.
                l = m + 1;
            }
        }

        // Actual time = workload * time per unit.
        ans = (ans * B) % MOD;

        return (int) ans;
    }

    public static void main(String[] args) {

        PaintersPartition obj =
                new PaintersPartition();

        int A = 2;
        int B = 5;
        int[] C = {1, 10};

        System.out.println(
                obj.paint(A, B, C)
        );
    }
}