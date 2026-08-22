/**
 * ============================================================
 * Problem            : Custom HashMap
 * Created By         : Karthik R
 *
 * Approach           : Hashing + Separate Chaining
 * Data Structure     : Array of Linked Lists
 *
 * Time Complexity:
 * put    -> O(1) average
 * get    -> O(1) average
 * remove -> O(1) average
 *
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Each bucket stores a linked list of key-value pairs.
 * - Hash function decides which bucket a key belongs to.
 * - Collision is handled using separate chaining.
 * - When load factor becomes greater than 2,
 *   the number of buckets is doubled and all entries
 *   are rehashed.
 * ============================================================
 */

public class CustomHashMap {

    // ============================================================
    // Node
    // ============================================================

    class Node {

        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // ============================================================
    // HashMap Variables
    // ============================================================

    private int bucketCount;
    private Node[] buckets;
    private int size;

    // ============================================================
    // Constructor
    // ============================================================

    public CustomHashMap() {

        bucketCount = 4;
        buckets = new Node[bucketCount];
        size = 0;
    }

    // ============================================================
    // Hash Function
    // ============================================================

    private int hash(int key) {

        return Math.floorMod(key, bucketCount);
    }

    // ============================================================
    // Put
    // ============================================================

    public void put(int key, int value) {

        int index = hash(key);

        Node head = buckets[index];

        // Key already exists -> update value
        while (head != null) {

            if (head.key == key) {
                head.value = value;
                return;
            }

            head = head.next;
        }

        // Insert new node at beginning
        Node newNode = new Node(key, value);

        newNode.next = buckets[index];
        buckets[index] = newNode;

        size++;

        // Check load factor
        double loadFactor =
                (1.0 * size) / bucketCount;

        if (loadFactor > 2.0) {
            rehash();
        }
    }

    // ============================================================
    // Get
    // ============================================================

    public int get(int key) {

        int index = hash(key);

        Node head = buckets[index];

        while (head != null) {

            if (head.key == key) {
                return head.value;
            }

            head = head.next;
        }

        return -1;
    }

    // ============================================================
    // Remove
    // ============================================================

    public int remove(int key) {

        int index = hash(key);

        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {

            if (curr.key == key) {

                // Removing first node
                if (prev == null) {
                    buckets[index] = curr.next;
                }

                // Removing middle/last node
                else {
                    prev.next = curr.next;
                }

                size--;

                return curr.value;
            }

            prev = curr;
            curr = curr.next;
        }

        return -1;
    }

    // ============================================================
    // Size
    // ============================================================

    public int size() {

        return size;
    }

    // ============================================================
    // Rehash
    // ============================================================

    private void rehash() {

        Node[] oldBuckets = buckets;

        // Double bucket count
        bucketCount *= 2;

        buckets = new Node[bucketCount];

        // Reset size because put() increments it
        size = 0;

        // Reinsert all nodes
        for (Node head : oldBuckets) {

            while (head != null) {

                Node next = head.next;

                put(head.key, head.value);

                head = next;
            }
        }
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        CustomHashMap map =
                new CustomHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);

        System.out.println(map.get(2));

        map.put(2, 500);

        System.out.println(map.get(2));

        System.out.println(map.size());

        System.out.println(map.remove(2));

        System.out.println(map.get(2));

        System.out.println(map.size());
    }
}