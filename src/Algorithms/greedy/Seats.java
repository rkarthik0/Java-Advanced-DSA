package Algorithms.Greedy;

import java.util.ArrayList;

/**
 * ============================================================
 * Problem            : Seats
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Median Position
 * Algorithm          : Greedy
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class Seats {

    /**
     * Finds the minimum number of jumps required to group all
     * occupied seats ('x') together.
     *
     * @param seats String representing occupied ('x') and empty ('.') seats
     * @return Minimum number of jumps modulo 10000003
     */
    public static int seats(String seats) {

        final int MOD = 10000003;

        // Stores the indices of occupied seats
        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < seats.length(); i++) {

            if (seats.charAt(i) == 'x') {
                positions.add(i);
            }
        }

        // No movement required if there are zero or one occupied seats
        if (positions.size() <= 1) {
            return 0;
        }

        // Choose the median occupied seat as the meeting point
        int median = positions.size() / 2;

        long moves = 0;

        // Move people on the left side towards the median
        int target = positions.get(median) - 1;

        for (int i = median - 1; i >= 0; i--) {

            moves += target - positions.get(i);
            moves %= MOD;

            target--;
        }

        // Move people on the right side towards the median
        target = positions.get(median) + 1;

        for (int i = median + 1; i < positions.size(); i++) {

            moves += positions.get(i) - target;
            moves %= MOD;

            target++;
        }

        return (int) moves;
    }

    public static void main(String[] args) {

        // Sample input
        String seats = "....x..xx...x..";

        // Calling the solution
        int result = seats(seats);

        // Printing output
        System.out.println("Minimum Moves: " + result);
    }
}