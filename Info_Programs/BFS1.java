import java.util.*;
public class BFS1
{
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        {
            int n = sc.nextInt();
            int e = sc.nextInt();
            List<Integer>[] g = new ArrayList[n+1];
            for(int i = 0; i <= n; i++)
            {
                g[i] = new ArrayList<>();
            }
            while(e-- >0 )
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                g[a].add(b);
                g[b].add(a);
            }
            int S = sc.nextInt();
            int D = sc.nextInt();
            int[] dist = new int[n + 1];
            Arrays.fill(dist, - 1);
            dist[S] =0;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(S);
            while(!q.isEmpty())
            {
                int u = q.poll();
                for(int v : g[u]){
                if(dist[v] < 0 )
                {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }

            }
 System.out.println(dist[D]);

        }
    }
}