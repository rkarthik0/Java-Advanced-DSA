/**
 * ============================================================
 * Problem            : Remove Duplicates from Sorted Linked List
 * Category           : Algorithms.LinkedList
 * Created By         : Karthik R
 *
 * Approach           : Iterative Traversal
 * Algorithm          : Two-Pointer / In-place Deletion
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Traverse the sorted linked list.
 * - If current node and next node have the same value,
 *   skip the next node.
 * - Otherwise move to the next node.
 * ============================================================
 */

public class RemoveDuplicatesSortedLinkedList {

    public ListNode deleteDuplicates(ListNode A) {

        ListNode t = A;

        while (t != null && t.next != null) {

            // Duplicate found: skip the next node.
            if (t.val == t.next.val) {
                t.next = t.next.next;
            }

            // No duplicate: move forward.
            else {
                t = t.next;
            }
        }

        return A;
    }

    public static void main(String[] args) {

        // Example:
        // 1 -> 1 -> 2 -> 3 -> 3
        // Result:
        // 1 -> 2 -> 3

        ListNode A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(2);
        A.next.next.next = new ListNode(3);
        A.next.next.next.next = new ListNode(3);

        RemoveDuplicatesSortedLinkedList obj =
                new RemoveDuplicatesSortedLinkedList();

        ListNode result = obj.deleteDuplicates(A);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}