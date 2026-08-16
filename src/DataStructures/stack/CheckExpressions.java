import java.util.*;

/**
 * ============================================================
 * Problem : Check if Two Algebraic Expressions Are Equivalent
 *
 * Approach:
 * Stack + Sign Propagation
 *
 * Time Complexity  : O(N + M)
 * Space Complexity : O(N + M)
 *
 * Idea:
 * Convert each expression into a 26-element sign array.
 *
 * Example:
 *
 *     a-(b-c)
 *
 * Expands to:
 *
 *     a - b + c
 *
 * Therefore:
 *
 *     a -> +1
 *     b -> -1
 *     c -> +1
 *
 * We don't actually need to expand the expression.
 * Instead, we propagate the sign using a stack.
 * ============================================================
 */

public class CheckExpressions {

    /**
     * Returns the sign of every variable.
     *
     * sign[i] = +1  -> variable appears positively
     * sign[i] = -1  -> variable appears negatively
     */
    public static int[] getSigns(String s) {

        int[] sign = new int[26];

        // Stack stores the sign caused by surrounding
        // parentheses.
        Stack<Integer> stack = new Stack<>();

        // Outside all parentheses, the sign is positive.
        stack.push(1);

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // ------------------------------------------------
            // Case 1: Variable
            // ------------------------------------------------
            if (c >= 'a' && c <= 'z') {

                int currentSign = stack.peek();

                /*
                 * If the immediately preceding character is '-',
                 * this variable gets the opposite sign.
                 *
                 * Example:
                 *     a-b
                 *
                 * b gets -1.
                 */
                if (i > 0 && s.charAt(i - 1) == '-') {
                    currentSign = -currentSign;
                }

                sign[c - 'a'] = currentSign;
            }

            // ------------------------------------------------
            // Case 2: Opening parenthesis
            // ------------------------------------------------
            else if (c == '(') {

                /*
                 * If '(' is preceded by '-',
                 * everything inside the parentheses changes sign.
                 *
                 * Example:
                 *
                 *     a-(b+c)
                 *
                 * becomes:
                 *
                 *     a-b-c
                 */
                if (i > 0 && s.charAt(i - 1) == '-') {
                    stack.push(-stack.peek());
                } else {
                    stack.push(stack.peek());
                }
            }

            // ------------------------------------------------
            // Case 3: Closing parenthesis
            // ------------------------------------------------
            else if (c == ')') {
                stack.pop();
            }
        }

        return sign;
    }

    /**
     * Checks whether two expressions are equivalent.
     */
    public static int solve(String A, String B) {

        int[] signsA = getSigns(A);
        int[] signsB = getSigns(B);

        // Compare the sign of every variable.
        for (int i = 0; i < 26; i++) {

            if (signsA[i] != signsB[i]) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        String A = "a-(b-c)";
        String B = "a-b+c";

        int result = solve(A, B);

        System.out.println(result);
    }
}