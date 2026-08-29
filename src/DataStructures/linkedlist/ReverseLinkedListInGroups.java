/**
 * ============================================================
 * Problem            : Reverse Linked List in Groups of B
 * Category           : Algorithms.LinkedList
 * Created By         : Karthik R
 *
 * Approach           : Recursion
 * Algorithm          : Reverse K Nodes at a Time
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(N / B) recursion stack
 *
 * Idea:
 * - Reverse the first B nodes iteratively.
 * - The original head becomes the tail of this reversed group.
 * - Recursively reverse the remaining list in groups of B.
 * - Connect the current group's tail to the next reversed group.
 * ============================================================
 */

public class ReverseLinkedListInGroups {

    public ListNode reverseList(ListNode A, int B) {

        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        // Reverse the first B nodes.
        while (current != null && count < B) {

            count++;

            // Save next node before changing the link.
            next = current.next;

            // Reverse current node.
            current.next = prev;

            // Move pointers forward.
            prev = current;
            current = next;
        }

        // current points to the next group.
        if (current != null) {

            // A is the original head and is now the tail
            // of the reversed group.
            A.next = reverseList(current, B);
        }

        // prev is the new head of this group.
        return prev;
    }

    public static void main(String[] args) {

        // Example:
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // B = 2
        //
        // Result:
        // 2 -> 1 -> 4 -> 3 -> 6 -> 5

        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(6);

        ReverseLinkedListInGroups obj =
                new ReverseLinkedListInGroups();

        ListNode result = obj.reverseList(A, 2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}