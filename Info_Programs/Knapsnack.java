/* sample input : 4 10
10 5
40 4
30 6
50 3
N = 4 items
W = 10 (bag capacity)

Value Weight

10    5
40    4
30    6
50    3

Sample output : 90

*/
import java.util.*;

public class Knapsnack {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Number of items
        int n = s.nextInt();

        // Maximum bag capacity
        int W = s.nextInt();

        /*
         * dp[c]
         * =
         * Maximum value achievable
         * using capacity c
         */
        int[] dp = new int[W + 1];

        // Process each item
        while (n-- > 0) {

            // Value of current item
            int value = s.nextInt();

            // Weight of current item
            int weight = s.nextInt();

            /*
             * Move from right to left
             * because each item can be used
             * only once (0/1 Knapsack)
             */
            for (int c = W; c >= weight; c--) {

                /*
                 * Option 1:
                 * Do not take current item
                 *
                 * dp[c]
                 *
                 * Option 2:
                 * Take current item
                 *
                 * dp[c - weight] + value
                 *
                 * Store the maximum
                 */
                dp[c] = Math.max(
                        dp[c],
                        dp[c - weight] + value
                );
            }
        }

        // Maximum value possible within capacity W
        System.out.println(dp[W]);
    }
}
