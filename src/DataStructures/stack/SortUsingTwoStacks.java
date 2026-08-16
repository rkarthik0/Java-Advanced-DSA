import java.util.*;

/**
 * ============================================================
 * Problem : Sort an Array Using Two Stacks
 *
 * Approach:
 * Two Stacks / Stack-based Insertion Sort
 *
 * Time Complexity  : O(N^2)
 * Space Complexity : O(N)
 *
 * Idea:
 *
 * st     -> original/unsorted stack
 * helper -> sorted stack
 *
 * For every element:
 *
 * 1. Remove the top element from st.
 * 2. While helper has elements greater than the current element,
 *    move them back to st.
 * 3. Put the current element into helper.
 *
 * This keeps helper sorted.
 * ============================================================
 */

public class SortUsingTwoStacks {

    public static int[] solve(int[] A) {

        int n = A.length;

        if (n <= 1) {
            return A;
        }

        Stack<Integer> st = new Stack<>();
        Stack<Integer> helper = new Stack<>();

        // Put all array elements into the first stack.
        for (int value : A) {
            st.push(value);
        }

        // Sort using two stacks.
        while (!st.isEmpty()) {

            // Take the top element from the unsorted stack.
            int current = st.pop();

            /*
             * Move larger elements back to st
             * until the correct position for current
             * is found.
             */
            while (!helper.isEmpty()
                    && helper.peek() > current) {

                st.push(helper.pop());
            }

            // Insert current into its correct position.
            helper.push(current);
        }

        /*
         * Move the sorted elements back to st.
         *
         * helper:
         *     top -> smallest
         *
         * After moving:
         * st:
         *     top -> largest
         *
         * Therefore popping st gives ascending order.
         */
        while (!helper.isEmpty()) {
            st.push(helper.pop());
        }

        // Convert sorted stack back to array.
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = st.pop();
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] A = {5, 3, 1, 4, 2};

        int[] result = solve(A);

        System.out.println(Arrays.toString(result));
    }
}