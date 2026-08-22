/**
 * ============================================================
 * Problem            : Colorful Number
 * Created By         : Karthik R
 *
 * Approach           : HashSet + Subarray Products
 * Algorithm          : Brute Force
 *
 * Time Complexity    : O(N^2)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Extract all digits of the number.
 * - Generate the product of every contiguous subarray.
 * - Store each product in a HashSet.
 * - If a product already exists, the number is not colorful.
 * ============================================================
 */

import java.util.*;

public class ColorfulNumber {

    public int colorful(int A) {

        HashSet<Integer> set = new HashSet<>();

        ArrayList<Integer> list = new ArrayList<>();

        // Extract digits
        while (A != 0) {

            int digit = A % 10;

            list.add(digit);

            A /= 10;
        }

        // Digits were extracted from right to left
        Collections.reverse(list);

        int n = list.size();

        // Generate every contiguous subarray
        for (int i = 0; i < n; i++) {

            int product = 1;

            for (int j = i; j < n; j++) {

                product *= list.get(j);

                // Duplicate product found
                if (set.contains(product)) {
                    return 0;
                }

                set.add(product);
            }
        }

        return 1;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        ColorfulNumber obj = new ColorfulNumber();

        int A = 3245;

        System.out.println(obj.colorful(A));
    }
}
