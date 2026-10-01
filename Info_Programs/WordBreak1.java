import java.util.*;
public class WordBreak1
{
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String x = sc.next();
        int n = sc.nextInt();
        Set<String> dict = new HashSet<>();
        while(n-- > 0)
        {
            dict.add(sc.next());
        }
        boolean[] dp = new boolean[x.length() + 1];
        dp[0] = true;
        for(int i = 0 ;  i <= x.length(); i++)
        {
            for(int j = 0; j < i ; j++)
            {
                if(dp[j] && dict.contains(x.substring(j,i)));
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(dp[x.length()] ? "YES" : "NO");
    }
}