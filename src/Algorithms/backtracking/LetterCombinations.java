/**
 * ============================================================
 * Problem            : Letter Combinations of a Phone Number
 * Created By         : Karthik R
 *
 * Approach           : Recursion + Backtracking
 * Algorithm          : Backtracking
 *
 * Time Complexity    : O(4^N * N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Each digit maps to a set of letters.
 * - Pick one letter for the current digit.
 * - Recursively process the next digit.
 * - After recursion, remove the chosen letter
 *   and try the next letter.
 * ============================================================
 */

import java.util.*;

public class LetterCombinations {

    // Digit -> corresponding letters
    String[] map = {
            "0", "1", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    ArrayList<String> ans = new ArrayList<>();

    public ArrayList<String> letterCombinations(String A) {

        // Important:
        // Clear the previous result if the same object
        // calls this method more than once.
        ans.clear();

        solve(A, 0, new StringBuilder());

        return ans;
    }

    // ============================================================
    // Backtracking function
    // ============================================================

    private void solve(
            String digits,
            int idx,
            StringBuilder cur) {

        // Base case:
        // All digits have been processed.
        if (idx == digits.length()) {

            ans.add(cur.toString());

            return;
        }

        // Get letters corresponding to current digit.
        String letters =
                map[digits.charAt(idx) - '0'];

        // Try every possible letter.
        for (int i = 0; i < letters.length(); i++) {

            // Choose
            cur.append(letters.charAt(i));

            // Explore
            solve(
                    digits,
                    idx + 1,
                    cur
            );

            // Undo choice
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        LetterCombinations obj =
                new LetterCombinations();

        String A = "23";

        ArrayList<String> result =
                obj.letterCombinations(A);

        System.out.println(result);
    }
}