/**
 * ============================================================
 * Problem            : Insert a Node at a Given Position
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Linked List
 * Algorithm          : Traversal and Insertion
 *
 * Time Complexity    : O(C)
 * Space Complexity   : O(1)
 *
 * Idea:
 * Create a new node and insert it at index C.
 *
 * - If C == 0, insert the node at the beginning.
 * - Otherwise, traverse to the node at index C - 1.
 * - Connect the new node between the current node and
 *   its next node.
 * ============================================================
 */

public class InsertNodeAtPosition {

    // Linked List Node
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode solve(ListNode A, int B, int C) {

        // Create the new node
        ListNode newNode = new ListNode(B);

        // If list is empty or insertion position is 0,
        // insert the new node at the beginning.
        if (A == null || C == 0) {

            newNode.next = A;

            return newNode;
        }

        ListNode current = A;

        // Move to the node just before the required position.
        //
        // For C = 2:
        // Stop at index 1.
        for (int i = 0; i < C - 1 && current.next != null; i++) {
            current = current.next;
        }

        // Connect new node to the next node
        newNode.next = current.next;

        // Connect current node to the new node
        current.next = newNode;

        // Head remains unchanged because insertion happened
        // somewhere after index 0.
        return A;
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {

            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create:
        // 1 -> 2 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);

        // Insert 3 at index 2
        head = solve(head, 3, 2);

        // Output:
        // 1 -> 2 -> 3 -> 4 -> 5
        System.out.println("Linked List after insertion:");
        printList(head);
    }
}