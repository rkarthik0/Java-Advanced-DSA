/**
 * ============================================================
 * Problem            : Copy List with Random Pointer
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/copy-list-with-random-pointer/
 * Difficulty         : Medium
 *
 * Approach           : Linked List
 * Algorithm          : Interweaving / In-Place Cloning
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1) auxiliary space
 *
 * Idea:
 * 1. Create a copy of every node and insert it immediately
 *    after the original node.
 *
 *    Original:
 *    A -> B -> C
 *
 *    After insertion:
 *    A -> A' -> B -> B' -> C -> C'
 *
 * 2. Set the random pointers of the copied nodes.
 *    If original.random points to X, then the copied node's
 *    random pointer should point to X.next.
 *
 * 3. Separate the original and copied lists.
 * ============================================================
 */

public class CopyListWithRandomPointer {

    // Node containing next and random pointers
    static class RandomListNode {

        int label;
        RandomListNode next;
        RandomListNode random;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {

        // Edge case
        if (head == null) {
            return null;
        }

        // ========================================================
        // STEP 1: Create duplicate nodes and insert them
        // immediately after their original nodes.
        // ========================================================

        RandomListNode curr = head;

        while (curr != null) {

            RandomListNode copy = new RandomListNode(curr.label);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        // ========================================================
        // STEP 2: Set random pointers of duplicate nodes.
        // ========================================================

        curr = head;

        while (curr != null) {

            RandomListNode copy = curr.next;

            if (curr.random != null) {

                // Original random points to X.
                // X.next is the duplicate of X.
                copy.random = curr.random.next;
            }

            curr = copy.next;
        }

        // ========================================================
        // STEP 3: Separate original and copied lists.
        // ========================================================

        RandomListNode original = head;
        RandomListNode copy = head.next;

        // Save the head of the copied list
        RandomListNode copyHead = copy;

        while (original != null) {

            // Restore original list
            original.next = copy.next;

            original = original.next;

            if (original != null) {

                // Connect copied node to the next copied node
                copy.next = original.next;
            }

            copy = copy.next;
        }

        return copyHead;
    }

    // Helper method to print the list
    private static void printList(RandomListNode head) {

        RandomListNode curr = head;

        while (curr != null) {

            System.out.print(curr.label);

            if (curr.random != null) {
                System.out.print("(random -> "
                        + curr.random.label + ")");
            } else {
                System.out.print("(random -> null)");
            }

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create:
        //
        // 1 -> 2 -> 3
        //
        // Random pointers:
        // 1 -> 3
        // 2 -> 1
        // 3 -> 2

        RandomListNode first = new RandomListNode(1);
        RandomListNode second = new RandomListNode(2);
        RandomListNode third = new RandomListNode(3);

        first.next = second;
        second.next = third;

        first.random = third;
        second.random = first;
        third.random = second;

        // Copy the list
        RandomListNode copiedHead = copyRandomList(first);

        System.out.println("Original List:");
        printList(first);

        System.out.println("Copied List:");
        printList(copiedHead);
    }
}