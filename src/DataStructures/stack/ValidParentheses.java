import java.util.*;

/**
 * ============================================================
 * Problem            : Valid Parentheses
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/valid-parentheses/
 * Difficulty         : Easy
 *
 * Approach           : Stack
 * Algorithm          : Matching Brackets
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 *
 * Idea:
 * Use a stack to store opening brackets.
 *
 * For every closing bracket:
 * - The stack must not be empty.
 * - The top of the stack must be its matching opening bracket.
 * - Otherwise, the string is invalid.
 *
 * At the end, the stack must be empty because every opening
 * bracket must have a matching closing bracket.
 * ============================================================
 */

public class ValidParentheses {

    public static int solve(String A) {

        Stack<Character> stack = new Stack<>();

        for (char c : A.toCharArray()) {

            // Push all opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                // A closing bracket without an opening bracket
                // is invalid.
                if (stack.isEmpty()) {
                    return 0;
                }

                char top = stack.peek();

                // Check whether the opening and closing
                // brackets form a valid pair.
                if ((top == '[' && c == ']')
                        || (top == '{' && c == '}')
                        || (top == '(' && c == ')')) {

                    stack.pop();

                } else {

                    // Mismatched brackets
                    return 0;
                }
            }
        }

        // Valid only when every opening bracket was matched
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {

        String A = "{[()]}";

        int result = solve(A);

        System.out.println("Valid Parentheses: " + result);
    }
}