/**
 * ============================================================
 * Problem            : Count Vowels
 * Created By         : Karthik R
 *
 * Approach           : String Traversal
 * Algorithm          : Contribution Technique
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - For every vowel at index i, it contributes to
 *   (N - i) substrings.
 * - Add the contribution of every vowel.
 * - Take modulo 10003.
 * ============================================================
 */

public class CountVowelSubstrings {

    public int solve(String A) {

        long count = 0;

        for (int i = 0; i < A.length(); i++) {

            if (isVowel(A.charAt(i))) {

                // Every substring starting at i or after i
                // can contain this vowel.
                count = (count + (A.length() - i)) % 10003;
            }
        }

        return (int) count;
    }

    private boolean isVowel(char c) {

        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {

        CountVowelSubstrings obj =
                new CountVowelSubstrings();

        String A = "ABEC";

        System.out.println(obj.solve(A));
    }
}