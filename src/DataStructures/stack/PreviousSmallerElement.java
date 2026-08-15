import java.util.*;

/**
 * ============================================================
 * Problem            : Previous Smaller Element
 * Created By         : Karthik R
 * Link               : https://www.interviewbit.com/problems/nearest-smaller-element/
 * Difficulty         : Easy
 *
 * Approach           : Stack
 * Algorithm          : Monotonic Stack
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 *
 * Idea:
 * For every element, find the nearest element on its left
 * that is strictly smaller than the current element.
 *
 * Maintain a stack containing possible smaller elements.
 *
 * If the stack top is greater than or equal to the current
 * element, remove it because it cannot be the previous
 * smaller element.
 * ============================================================
 */

public class PreviousSmallerElement {

    public static int[] prevSmaller(int[] A) {

        int n = A.length;

        int[] answer = new int[n];

        // Stack stores possible previous smaller elements
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Remove elements that are not smaller
            // than the current element.
            while (!stack.isEmpty() && A[i] <= stack.peek()) {
                stack.pop();
            }

            // If no smaller element exists on the left
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                // Stack top is the nearest smaller element
                answer[i] = stack.peek();
            }

            // Current element becomes a candidate
            // for future elements.
            stack.push(A[i]);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] A = {4, 5, 2, 10, 8};

        int[] result = prevSmaller(A);

        System.out.println(Arrays.toString(result));
    }
}