import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of coin denominations
        int n = sc.nextInt();

        // Store coin denominations
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // Read target value
        int target = sc.nextInt();

        /*
         * dp[i] = minimum number of coins required
         * to make sum i.
         */

        int[] dp = new int[target + 1];

        // Initialize all values with a large number
        Arrays.fill(dp, target + 1);

        // Base case:
        // 0 coins are needed to make value 0
        dp[0] = 0;

        // Unbounded Knapsack DP
        // Each coin can be used unlimited times
        for (int coin : coins) {

            for (int amount = coin; amount <= target; amount++) {

                dp[amount] = Math.min(
                        dp[amount],
                        dp[amount - coin] + 1
                );
            }
        }

        // If target cannot be formed, print -1
        // Otherwise print minimum coins required
        System.out.println(dp[target] > target ? -1 : dp[target]);
    }
}

/*
==================================================
SAMPLE INPUT
==================================================
3
1 3 4
6

==================================================
SAMPLE OUTPUT
==================================================
2

==================================================
EXPLANATION
==================================================

Number of coin types = 3

Coins:
[1, 3, 4]

Target Value = 6

Possible ways:

1 + 1 + 1 + 1 + 1 + 1 = 6   (6 coins)

3 + 3 = 6                   (2 coins)

4 + 1 + 1 = 6               (3 coins)

Minimum coins required = 2

Therefore output = 2

==================================================
TIME COMPLEXITY
==================================================
O(N * V)

N = Number of coin denominations
V = Target value

==================================================
SPACE COMPLEXITY
==================================================
O(V)

Only one DP array is used.
==================================================
*/