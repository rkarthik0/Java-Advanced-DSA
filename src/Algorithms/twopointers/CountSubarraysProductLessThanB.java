/**
 * ============================================================
 * Problem            : Count Subarrays With Product < B
 * Created By         : Karthik R
 *
 * Approach           : Two Pointers / Sliding Window
 * Algorithm          : Product Based Sliding Window
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Maintain a window [l ... r] whose product is < B.
 * - When A[l] * A[r] < B, all subarrays ending at r
 *   inside the current window are valid.
 * - Number of such subarrays = r - l + 1.
 *
 * Note:
 * This solution specifically uses the property of the
 * problem where the array is sorted and positive.
 * ============================================================
 */

public class CountSubarraysProductLessThanB {

    public int solve(int[] A, int B) {

        long mod = 1000000007L;

        int n = A.length;

        int l = 0;
        int r = n - 1;

        long ans = 0;

        while (l <= r) {

            long area = (long) A[l] * A[r];

            if (area < B) {

                /*
                 * Since A is sorted:
                 *
                 * A[l] <= A[l+1] <= ... <= A[r]
                 *
                 * If A[l] * A[r] < B,
                 * then A[i] * A[r] < B for every i >= l.
                 *
                 * Therefore, for this r:
                 *
                 * [l ... r]      -> valid
                 * [l+1 ... r]    -> valid
                 * [l+2 ... r]    -> valid
                 * ...
                 * [r ... r]      -> valid
                 *
                 * Number of valid subarrays = r - l + 1.
                 *
                 * Why does the code have:
                 *     2 * (r-l) + 1 ?
                 *
                 * Because this problem is counting SUBSEQUENCES,
                 * not ordinary subarrays:
                 *
                 * There are:
                 *
                 *     (r-l) elements before r
                 *
                 * Single-element choices = r-l+1
                 *
                 * Pair choices involving r = r-l
                 *
                 * Total = (r-l+1) + (r-l)
                 *       = 2*(r-l) + 1
                 */

                ans = (ans + (2L * (r - l) + 1)) % mod;

                // Move left pointer forward.
                l++;
            }

            else {

                // Product is too large.
                // Reduce the product by moving r left.
                r--;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {

        CountSubarraysProductLessThanB obj =
                new CountSubarraysProductLessThanB();

        int[] A = {1, 2, 3, 4};

        int B = 10;

        System.out.println(obj.solve(A, B));
    }
}