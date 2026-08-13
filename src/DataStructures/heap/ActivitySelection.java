import java.util.*;

/**
 * ============================================================
 * Problem            : Activity Selection
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Greedy
 * Algorithm          : Activity Selection by Earliest Finish Time
 *
 * Time Complexity    : O(n log n)
 * Space Complexity   : O(n)
 *
 * Idea:
 * Sort all jobs by their finish time.
 *
 * Always select the job that finishes earliest and does not
 * overlap with the previously selected job.
 *
 * This leaves the maximum possible remaining time for
 * selecting future jobs.
 * ============================================================
 */

public class ActivitySelection {

    public static int solve(int[] A, int[] B) {

        int n = A.length;

        // Store start time and finish time together
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = A[i]; // Start time
            jobs[i][1] = B[i]; // Finish time
        }

        // Sort jobs by finish time
        Arrays.sort(jobs, (a, b) ->
                Integer.compare(a[1], b[1])
        );

        // Select the first job
        int jobCount = 1;
        int lastFinishTime = jobs[0][1];

        // Select non-overlapping jobs
        for (int i = 1; i < n; i++) {

            // Current job can be selected if its
            // start time is >= previous finish time.
            if (jobs[i][0] >= lastFinishTime) {

                jobCount++;
                lastFinishTime = jobs[i][1];
            }
        }

        return jobCount;
    }

    public static void main(String[] args) {

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};

        int result = solve(start, finish);

        System.out.println("Maximum Number of Jobs: " + result);
    }
}