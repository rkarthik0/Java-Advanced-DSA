/**
 * ============================================================
 * Problem            : Reverse Linked List II
 * Category           : Algorithms.LinkedList
 * Created By         : Karthik R
 *
 * Approach           : In-place Reversal
 * Algorithm          : Iterative Linked List Reversal
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Move to the Bth node.
 * - Reverse nodes from B to C.
 * - Connect the reversed portion with the remaining list.
 * - Handle B == 1 separately because the head changes.
 * ============================================================
 */

public class ReverseLinkedListRange {

    public ListNode reverseBetween(ListNode A, int B, int C) {

        // No reversal needed.
        if (A == null || B == C) {
            return A;
        }

        ListNode current = A;
        ListNode prev = null;

        // Move current to the Bth node.
        for (int i = 1; i < B; i++) {
            prev = current;
            current = current.next;
        }

        // Store the node before B.
        ListNode connection = prev;

        // Bth node becomes the tail after reversal.
        ListNode tail = current;

        // Reverse nodes from B to C.
        for (int i = 0; i < C - B + 1; i++) {

            ListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        // Connect the first part to the reversed portion.
        if (connection != null) {
            connection.next = prev;
        } else {
            // B == 1, so the reversed node becomes the new head.
            A = prev;
        }

        // Connect the reversed portion to the remaining list.
        tail.next = current;

        return A;
    }

    public static void main(String[] args) {

        // Example:
        // 1 -> 2 -> 3 -> 4 -> 5
        // B = 2, C = 4
        //
        // Result:
        // 1 -> 4 -> 3 -> 2 -> 5

        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);

        ReverseLinkedListRange obj =
                new ReverseLinkedListRange();

        ListNode result = obj.reverseBetween(A, 2, 4);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}