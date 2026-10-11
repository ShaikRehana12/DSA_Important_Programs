import java.util.*;
public class knapsack1
{
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] dp = new int[w+1];
        while(n-- > 0)
        {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            for(int c = w; c >= weight; c--)
            {
                dp[c] = Math.max(dp[c], dp[c - weight] + value);
            }
        }
        System.out.println(dp[w]);
    }
}