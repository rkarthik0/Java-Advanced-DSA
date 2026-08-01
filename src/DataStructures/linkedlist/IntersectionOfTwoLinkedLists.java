package DataStructures.LinkedList;

/**
 * ============================================================
 * Problem            : Intersection of Two Linked Lists
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Difficulty         : Easy
 *
 * Approach           : Two Pointers
 * Algorithm          : Pointer Switching
 *
 * Time Complexity    : O(m + n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class IntersectionOfTwoLinkedLists {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Finds the intersection node of two singly linked lists.
     *
     * @param headA Head of the first linked list
     * @param headB Head of the second linked list
     * @return Intersection node if present, otherwise null
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Edge case
        if (headA == null || headB == null) {
            return null;
        }

        // Initialize two pointers
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse until both pointers meet
        while (pointerA != pointerB) {

            // Switch to the other list after reaching the end
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Returns the intersection node or null
        return pointerA;
    }

    public static void main(String[] args) {

        // Common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // First linked list: 3 -> 7 -> 8 -> 10
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        // Second linked list: 99 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = common;

        // Calling the solution
        ListNode intersection = getIntersectionNode(headA, headB);

        // Printing output
        if (intersection != null) {
            System.out.println("Intersection Node: " + intersection.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}