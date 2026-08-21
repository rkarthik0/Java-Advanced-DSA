/**
 * ============================================================
 * Problem            : Partition Array
 * Created By         : Karthik R
 *
 * Approach           : Partitioning
 * Algorithm          : Quick Sort Partition
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Choose the last element as the pivot.
 * - Move elements smaller than pivot to the left.
 * - Move elements greater than pivot to the right.
 * - Finally place the pivot at its correct position.
 * ============================================================
 */

public class PartitionArray {

    public int partition(int[] arr) {

        int n = arr.length;

        int l = 0;
        int r = n - 2;

        // Last element is the pivot
        int p = n - 1;

        while (l <= r) {

            // Left element is already smaller than pivot
            if (arr[l] < arr[p]) {
                l++;
            }

            // Right element is already greater than pivot
            else if (arr[r] > arr[p]) {
                r--;
            }

            // Both elements need to be swapped
            else {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l++;
                r--;
            }
        }

        // Put pivot at its correct position
        int temp = arr[p];
        arr[p] = arr[l];
        arr[l] = temp;

        return l;
    }

    public static void main(String[] args) {

        PartitionArray obj = new PartitionArray();

        int[] arr = {4, 2, 7, 3, 6};

        int pivotIndex = obj.partition(arr);

        System.out.println("Pivot index: " + pivotIndex);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}