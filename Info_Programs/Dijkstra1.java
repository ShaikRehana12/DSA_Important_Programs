import java.util.*;
public class Dijkstra1
{
    static class E
    {
        int v;
        int w;
        E(int v ,int w)
        {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =sc.nextInt();
        List<E>[] g = new ArrayList[n];
        for(int i = 0; i < n ; i++)
        {
            g[i] = new ArrayList<>();
        }
        while(m-- > 0)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g[u].add(new E(v, w));
        }
        int S = sc.nextInt();
        long INF  = Long.MAX_VALUE / 4 ;
        long[] dist = new long[n];
        Arrays.fill(dist,INF);
        dist[S] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
        pq.add(new long[]{0,S});
        while(!pq.isEmpty())
        {
            long[] current = pq.poll();
            long currentDistance = current[0];
            int u = (int) current[1];
            if(currentDistance != dist[u])
            {
                continue;
            }
            for(E edge : g[u])
            {
                if(dist[edge.v] > currentDistance + edge.w)
                {
                    dist[edge.v] = currentDistance + edge.w;
                    pq.add(new long[]{dist[edge.v], edge.v});
                }
            }
        }
        for(long d : dist)
        {
            if(d == INF)
                System.out.print("-1");
            else
                System.out.print(d+" ");
        }
    }
}