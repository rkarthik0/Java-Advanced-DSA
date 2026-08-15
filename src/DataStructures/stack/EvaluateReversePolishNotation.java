import java.util.*;

/**
 * ============================================================
 * Problem            : Evaluate Reverse Polish Notation
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Difficulty         : Medium
 *
 * Approach           : Stack
 * Algorithm          : Reverse Polish Notation Evaluation
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 *
 * Idea:
 * In Reverse Polish Notation, operators come after their
 * operands.
 *
 * Example:
 * 2 1 + 3 *
 *
 * Steps:
 * 2, 1 -> 2 + 1 = 3
 * 3, 3 -> 3 * 3 = 9
 *
 * For every operator:
 * - Pop the second operand first.
 * - Pop the first operand second.
 * - Perform the operation as a op b.
 * - Push the result back into the stack.
 * ============================================================
 */

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] A) {

        Stack<Integer> stack = new Stack<>();

        for (String token : A) {

            // Check whether the current token is an operator
            if (token.equals("+")
                    || token.equals("-")
                    || token.equals("*")
                    || token.equals("/")) {

                // IMPORTANT:
                // The first value popped is the SECOND operand.
                int b = stack.pop();

                // The second value popped is the FIRST operand.
                int a = stack.pop();

                // Perform the required operation
                if (token.equals("+")) {
                    stack.push(a + b);
                }

                if (token.equals("-")) {
                    stack.push(a - b);
                }

                if (token.equals("*")) {
                    stack.push(a * b);
                }

                if (token.equals("/")) {
                    stack.push(a / b);
                }

            } else {

                // Token is a number
                stack.push(Integer.parseInt(token));
            }
        }

        // Final value in the stack is the answer
        return stack.pop();
    }

    public static void main(String[] args) {

        String[] expression = {
                "2", "1", "+", "3", "*"
        };

        int result = evalRPN(expression);

        System.out.println("Result: " + result);
    }
}