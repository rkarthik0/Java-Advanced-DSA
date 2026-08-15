import java.util.*;

/**
 * ============================================================
 * Problem            : Stack Operations
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Stack
 * Algorithm          : Push and Pop Simulation
 *
 * Time Complexity    : O(A)
 * Space Complexity   : O(A)
 *
 * Idea:
 * Start the stack with B.
 *
 * For every operation in C:
 * - If the value is 0, remove the top element.
 * - Otherwise, push the value into the stack.
 *
 * The final element remaining at the top is the answer.
 * ============================================================
 */

public class StackOperations {

    public static int solve(int A, int B, int[] C) {

        Stack<Integer> stack = new Stack<>();

        // Initial value
        stack.push(B);

        // Process all operations
        for (int i = 0; i < A; i++) {

            if (C[i] == 0) {

                // Remove the top element
                stack.pop();

            } else {

                // Add the value to the stack
                stack.push(C[i]);
            }
        }

        // Return the final top element
        return stack.pop();
    }

    public static void main(String[] args) {

        int A = 5;
        int B = 10;
        int[] C = {5, 3, 0, 7, 0};

        int result = solve(A, B, C);

        System.out.println("Final Element: " + result);
    }
}