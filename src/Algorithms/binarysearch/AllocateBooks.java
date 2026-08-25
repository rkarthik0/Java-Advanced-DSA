/**
 * ============================================================
 * Problem            : Allocate Books
 * Created By         : Karthik R
 *
 * Approach           : Binary Search on Answer
 * Algorithm          : Binary Search + Greedy
 *
 * Time Complexity    : O(N log(S))
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Minimum possible maximum pages = maximum pages in one book.
 * - Maximum possible maximum pages = total pages.
 * - Binary search for the minimum possible maximum pages.
 * - check() greedily assigns consecutive books to students.
 * ============================================================
 */

public class AllocateBooks {

    public int books(int[] A, int B) {

        int l = 0;
        int h = 0;

        // Find the search range.
        for (int pages : A) {

            // One student must be able to read
            // the largest single book.
            l = Math.max(l, pages);

            // One student could read all books.
            h += pages;
        }

        int ans = 0;

        // Binary search for minimum maximum pages.
        while (l <= h) {

            int m = l + (h - l) / 2;

            if (check(A, m, B)) {

                // m is possible.
                // Try a smaller maximum.
                ans = m;
                h = m - 1;

            } else {

                // m is not possible.
                // Need a larger maximum.
                l = m + 1;
            }
        }

        return ans;
    }

    // Checks whether all books can be allocated
    // to B students with at most m pages per student.
    public boolean check(int[] A, int m, int B) {

        int students = 1;
        int sum = 0;

        for (int pages : A) {

            sum += pages;

            // Current student cannot take this book.
            if (sum > m) {

                students++;

                // Give this book to the next student.
                sum = pages;
            }

            // More students than available.
            if (students > B) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        AllocateBooks obj =
                new AllocateBooks();

        int[] A = {12, 34, 67, 90};
        int B = 2;

        System.out.println(
                obj.books(A, B)
        );
    }
}