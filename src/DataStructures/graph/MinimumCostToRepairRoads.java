import java.util.*;

public class MinimumCostToRepairRoads {

    // Time Complexity: O(N log N + M log M)
    // Space Complexity: O(N + M)

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        final long MOD = 1000000007L;

        // Sort both road types in descending order.
        // Repair the most expensive road first.
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());

        int n = A.size();
        int m = B.size();

        // Number of horizontal and vertical sections created so far.
        long horizontalParts = 1;
        long verticalParts = 1;

        long cost = 0;

        int i = 0;
        int j = 0;

        // Choose the more expensive road first.
        while (i < n && j < m) {

            if (A.get(i) > B.get(j)) {

                // Horizontal road crosses all vertical sections.
                cost = (cost +
                        (A.get(i) * verticalParts) % MOD) % MOD;

                horizontalParts++;
                i++;

            } else {

                // Vertical road crosses all horizontal sections.
                cost = (cost +
                        (B.get(j) * horizontalParts) % MOD) % MOD;

                verticalParts++;
                j++;
            }
        }

        // Process remaining horizontal roads.
        while (i < n) {

            cost = (cost +
                    (A.get(i) * verticalParts) % MOD) % MOD;

            horizontalParts++;
            i++;
        }

        // Process remaining vertical roads.
        while (j < m) {

            cost = (cost +
                    (B.get(j) * horizontalParts) % MOD) % MOD;

            verticalParts++;
            j++;
        }

        return (int) cost;
    }
}