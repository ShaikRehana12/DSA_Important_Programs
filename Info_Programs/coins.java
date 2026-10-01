import java.util.*;
public class coins {
    static final long MOD = 1_000_000_007L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        long[] dp = new long[target + 1];
        dp[0] = 1; // One way to make zero: choose no coins.
        for (int i = 0; i < n; i++) {
            int coin = sc.nextInt();
            for (int amount = coin; amount <= target; amount++) {
                dp[amount] = (dp[amount] + dp[amount - coin]) % MOD;
            }
        }
        System.out.println(dp[target]);
    }
}