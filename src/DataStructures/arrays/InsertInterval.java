package datastructures.arrays;

/**
 * ============================================================
 * Problem            : Insert Interval
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/insert-interval/
 * Difficulty         : Medium
 *
 * Approach           : Three Pass Interval Processing
 * Algorithm          : Greedy Interval Merging
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class InsertInterval {

    /**
     * Inserts a new interval into a sorted list of intervals
     * and merges overlapping intervals.
     *
     * @param intervals Existing sorted intervals
     * @param newInterval New interval to insert
     * @return Updated intervals after insertion and merging
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;

        // Pointer for traversing existing intervals
        int i = 0;

        // Index for storing result intervals
        int idx = 0;

        // Temporary array to store merged intervals
        int[][] result = new int[n + 1][2];


        // Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {

            result[idx][0] = intervals[i][0];
            result[idx][1] = intervals[i][1];

            i++;
            idx++;
        }


        // Merge overlapping intervals
        int start = newInterval[0];
        int end = newInterval[1];

        while (i < n && intervals[i][0] <= end) {

            // Expand the range of the merged interval
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);

            i++;
        }


        // Add the merged interval
        result[idx][0] = start;
        result[idx][1] = end;
        idx++;


        // Add remaining intervals after the merged interval
        while (i < n) {

            result[idx][0] = intervals[i][0];
            result[idx][1] = intervals[i][1];

            i++;
            idx++;
        }


        // Create final array with exact required size
        int[][] answer = new int[idx][2];

        for (int j = 0; j < idx; j++) {

            answer[j][0] = result[j][0];
            answer[j][1] = result[j][1];

        }

        return answer;
    }


    public static void main(String[] args) {

        // Sample input
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = {2, 5};


        // Calling solution
        int[][] result = insert(intervals, newInterval);


        // Printing output
        for (int[] interval : result) {

            System.out.println(
                    "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}