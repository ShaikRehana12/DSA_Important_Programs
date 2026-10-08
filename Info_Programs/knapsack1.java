import java.util.*;
class Knapsack1
{
    public static void main(String ar[])
    {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] dp = new int[W + 1];
        while(n-- > 0)
        {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            for(int c = W; c > weight; c--)
            {
                dp[c] = Math.max(dp[c], dp[c - weight] + value);
            }
        }
        System.out.println(dp[W]);
    }
}