import java.util.*;
public class MinimumCoins1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coin = new int[n];
        for(int i = 0; i < n; i++)
        {
            coin[i] = sc.nextInt();
        }
        int target  = sc.nextInt();
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for(int coins : coin){
        for(int amount = coins; amount <= target ; amount++)
        {
            dp[amount] = Math.min(dp[amount], dp[amount - coins] + 1);
        }
        
    }
    System.out.println(dp[target] > target ? -1 : dp[target]);
    }
}