import java.util.*;

/**
 * ============================================================
 * Problem            : Assign Mice to Holes
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Greedy
 * Algorithm          : Sort and Pair
 *
 * Time Complexity    : O(n log n)
 * Space Complexity   : O(1) auxiliary space
 *
 * Idea:
 * Sort both the mouse positions and hole positions.
 *
 * Pair the ith mouse with the ith hole.
 *
 * This pairing minimizes the maximum distance any mouse
 * has to travel.
 * ============================================================
 */

public class Mice {

    public static int mice(int[] A, int[] B) {

        // Sort mouse positions
        Arrays.sort(A);

        // Sort hole positions
        Arrays.sort(B);

        int maxTime = 0;

        // Pair the ith mouse with the ith hole
        for (int i = 0; i < A.length; i++) {

            // Time required for the current mouse
            int time = Math.abs(A[i] - B[i]);

            // Keep track of the maximum time
            maxTime = Math.max(maxTime, time);
        }

        return maxTime;
    }

    public static void main(String[] args) {

        int[] micePositions = {4, 2, 1, 4};
        int[] holePositions = {1, 3, 5, 7};

        int result = mice(micePositions, holePositions);

        System.out.println("Minimum Maximum Time: " + result);
    }
}