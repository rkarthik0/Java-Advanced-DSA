import java.util.*;

/**
 * ============================================================
 * Problem            : Seats
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Greedy
 * Algorithm          : Median-Based Greedy
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 *
 * Idea:
 * Store the positions of all occupied seats ('x').
 *
 * The optimal meeting point is around the median occupied seat.
 * Moving people toward the median minimizes the total number
 * of adjacent moves.
 *
 * We skip already occupied positions while calculating moves.
 * ============================================================
 */

public class Seats {

    public static int seats(String A) {

        final int MOD = 10000003;

        // Store positions of all occupied seats
        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                positions.add(i);
            }
        }

        // Zero or one person requires no movement
        if (positions.size() <= 1) {
            return 0;
        }

        int mid = positions.size() / 2;

        long answer = 0;

        // Move people on the left toward the median
        int target = positions.get(mid) - 1;

        for (int i = mid - 1; i >= 0; i--) {

            answer += target - positions.get(i);
            answer %= MOD;

            // Move target one position left
            target--;
        }

        // Move people on the right toward the median
        target = positions.get(mid) + 1;

        for (int i = mid + 1; i < positions.size(); i++) {

            answer += positions.get(i) - target;
            answer %= MOD;

            // Move target one position right
            target++;
        }

        return (int) answer;
    }

    public static void main(String[] args) {

        String A = "....x..xx...x..";

        int result = seats(A);

        System.out.println("Minimum Moves: " + result);
    }
}