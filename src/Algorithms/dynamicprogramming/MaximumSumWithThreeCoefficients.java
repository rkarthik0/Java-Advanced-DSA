/**
 * ============================================================
 * Problem            : Maximum Sum with Three Coefficients
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Dynamic Programming
 * Algorithm          : Bottom-Up DP (Tabulation)
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class MaximumSumWithThreeCoefficients {

    public static int solve(int[] A, int B, int C, int D) {

        int n = A.length;

        // dp1[i] = maximum value of A[x] * B
        // where x <= i
        int[] dp1 = new int[n];

        // dp2[i] = maximum value of
        // A[x] * B + A[y] * C
        // where x <= y <= i
        int[] dp2 = new int[n];

        // dp3[i] = maximum value of
        // A[x] * B + A[y] * C + A[z] * D
        // where x <= y <= z <= i
        int[] dp3 = new int[n];

        // --------------------------------------------------------
        // STEP 1: Choose the B part
        // --------------------------------------------------------

        dp1[0] = A[0] * B;

        for (int i = 1; i < n; i++) {

            // Either keep the previous best value
            // or choose A[i] for the B coefficient.
            dp1[i] = Math.max(
                    dp1[i - 1],
                    A[i] * B
            );
        }

        // --------------------------------------------------------
        // STEP 2: Choose the C part
        // --------------------------------------------------------

        // x <= y, and both can be 0.
        dp2[0] = dp1[0] + A[0] * C;

        for (int i = 1; i < n; i++) {

            // Option 1:
            // Do not choose i for the C part.
            int option1 = dp2[i - 1];

            // Option 2:
            // Choose A[i] for the C part.
            //
            // dp1[i] contains the best B part
            // from an index <= i.
            int option2 = dp1[i] + A[i] * C;

            dp2[i] = Math.max(option1, option2);
        }

        // --------------------------------------------------------
        // STEP 3: Choose the D part
        // --------------------------------------------------------

        // x <= y <= z, and all can be 0.
        dp3[0] = dp2[0] + A[0] * D;

        for (int i = 1; i < n; i++) {

            // Option 1:
            // Do not choose i for the D part.
            int option1 = dp3[i - 1];

            // Option 2:
            // Choose A[i] for the D part.
            //
            // dp2[i] contains the best B + C combination
            // from indices <= i.
            int option2 = dp2[i] + A[i] * D;

            dp3[i] = Math.max(option1, option2);
        }

        return dp3[n - 1];
    }

    public static void main(String[] args) {

        int[] A = {1, 5, 3, 2};
        int B = 2;
        int C = 3;
        int D = 4;

        int result = solve(A, B, C, D);

        System.out.println("Maximum Value: " + result);
    }
}