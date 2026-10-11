import java.util.*;

public class Slidingwindow {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // Number of elements
        int n = s.nextInt();

        // Window size
        int k = s.nextInt();

        // Input array
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        /*
         * Monotonic Deque
         *
         * Stores indices
         *
         * Values corresponding to those indices
         * remain in decreasing order.
         */
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            /*
             * Remove indices that are outside
             * the current window.
             */
            while (!d.isEmpty() &&
                    d.peekFirst() <= i - k) {

                d.pollFirst();
            }

            /*
             * Remove all smaller elements
             * from the back.
             *
             * They can never become maximum
             * while current element exists.
             */
            while (!d.isEmpty() &&
                    a[d.peekLast()] <= a[i]) {

                d.pollLast();
            }

            /*
             * Add current index
             */
            d.addLast(i);

            /*
             * First complete window appears
             * when i reaches k - 1
             */
            if (i >= k - 1) {

                /*
                 * Front of deque always stores
                 * the maximum element's index.
                 */
                System.out.print(
                        a[d.peekFirst()] + " "
                );
            }
        }
    }
}