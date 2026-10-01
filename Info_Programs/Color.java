import java.util.*;

public class Color {

    // Large value representing infinity
    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String ar[]) {

        Scanner sc = new Scanner(System.in);

        // n = number of posts
        int n = sc.nextInt();

        // k = number of colors
        int k = sc.nextInt();

        // cost[i][c] = cost of painting post i with color c
        long[][] cost = new long[n][k];

        // Read painting costs
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < k; c++) {
                cost[i][c] = sc.nextLong();
            }
        }

        // fatigue[c] = extra fatigue cost if same color
        // is used for two consecutive posts
        long[] fatigue = new long[k];

        for (int c = 0; c < k; c++) {
            fatigue[c] = sc.nextLong();
        }

        /*
         * dp[color][run]
         *
         * color = last color used
         *
         * run = 1 -> color used once
         * run = 2 -> color used twice consecutively
         *
         * Example:
         *
         * dp[0][1]
         * means:
         * last painted color = 0
         * color 0 used only once consecutively
         */

        long[][] dp = new long[k][3];

        // Initialize with infinity
        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        /*
         * First post initialization
         *
         * If post 0 is painted with color c,
         * cost will simply be cost[0][c]
         */

        for (int c = 0; c < k; c++) {
            dp[c][1] = cost[0][c];
        }

        /*
         * Process remaining posts
         */

        for (int i = 1; i < n; i++) {

            long[][] next = new long[k][3];

            for (long[] row : next) {
                Arrays.fill(row, INF);
            }

            /*
             * Try all previous states
             */

            for (int last = 0; last < k; last++) {

                for (int run = 1; run <= 2; run++) {

                    // Skip impossible states
                    if (dp[last][run] == INF)
                        continue;

                    /*
                     * Try assigning current post
                     * with every color
                     */

                    for (int cur = 0; cur < k; cur++) {

                        /*
                         * CASE 1:
                         * Current color = Previous color
                         *
                         * Allowed only when previously
                         * used exactly once
                         *
                         * Run becomes 2
                         *
                         * Add fatigue cost
                         */

                        if (cur == last && run == 1) {

                            next[cur][2] = Math.min(
                                    next[cur][2],
                                    dp[last][run]
                                            + cost[i][cur]
                                            + fatigue[cur]);
                        }

                        /*
                         * CASE 2:
                         * Different color
                         *
                         * Run resets to 1
                         */

                        else if (cur != last) {

                            next[cur][1] = Math.min(
                                    next[cur][1],
                                    dp[last][run]
                                            + cost[i][cur]);
                        }
                    }
                }
            }

            // Move DP forward
            dp = next;
        }

        /*
         * Find minimum answer among all valid states
         */

        long answer = INF;

        for (int c = 0; c < k; c++) {

            answer = Math.min(
                    answer,
                    Math.min(dp[c][1], dp[c][2]));
        }

        System.out.println(answer);
    }
}