import java.util.*;
public class Color2
{
    static final long INF = Long.MAX_VALUE / 4;
    public static  void main(String ar[])
    {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] cost  = new long[n][k];
        for(int i = 0 ; i < n ; i++)
        {
            for(int c = 0 ; c <k ;c++)
            {
                cost[i][c] = sc.nextLong();
            }
        }
        long[] fatigue = new long[k];
        for(int c  = 0 ; c < k ; c++)
            fatigue[c] = sc.nextLong();
        long[][] dp = new long[k][3];
        for(long[] row : dp ) Arrays.fill(row, INF);
        for(int c = 0 ; c < k; c++) dp[c][1] = cost[0][c];
        for(int i = 1; i < n ; i++)
        {
            long[][] next = new long[k][3];
            for(long[] row: next) Arrays.fill(row, INF);
            for(int last = 0; last < k ; last++)
            {
                for(int run = 1 ; run <=2 ; run++)
                {
                    if(dp[last][run] == INF) continue;
                    for(int cur = 0; cur < k ; cur++)
                    {
                        if(cur == last && run == 1)
                        {
                            next[cur][2] = Math.min(next[cur][2], dp[last][run] + cost[i][cur] + fatigue[cur]);
                        }
                        else if(cur != last)
                        {
                            next[cur][1] = Math.min(next[cur][1], dp[last][run] + cost[i][cur]);
                        }
                    }
                }
            }
            dp = next;
        }
        long answer  = INF;
        for(int c  = 0; c < k ; c++)
        {
            answer = Math.min(answer, Math.min(dp[c][1], dp[c][2]));
        }
        System.out.println(answer);
    }
}