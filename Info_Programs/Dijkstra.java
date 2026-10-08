// 5 6
// 0 1 2
// 0 2 4
// 1 2 1
// 1 3 7
// 2 4 3
// 3 4 1
// 0     --upto this lines input
// 0 2 3 9 6  -- output

import java.util.*;

public class Dijkstra {

    /*
     * Edge class
     *
     * v = destination vertex
     * w = edge weight
     */
    static class E {

        int v;
        int w;

        E(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // Number of vertices
        int n = s.nextInt();

        // Number of edges
        int m = s.nextInt();

        // Adjacency list
        List<E>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        /*
         * Read all edges
         *
         * u -> source node
         * v -> destination node
         * w -> edge weight
         */
        while (m-- > 0) {

            int u = s.nextInt();
            int v = s.nextInt();
            int w = s.nextInt();

            g[u].add(new E(v, w));
        }

        // Source vertex
        int S = s.nextInt();

        // Large value representing infinity
        long INF = Long.MAX_VALUE / 4;

        // Distance array
        long[] dist = new long[n];

        Arrays.fill(dist, INF);

        // Distance from source to itself is 0
        dist[S] = 0;

        /*
         * Min Heap
         *
         * [distance, node]
         */
        PriorityQueue<long[]> pq =
                new PriorityQueue<>(
                        Comparator.comparingLong(x -> x[0])
                );

        // Insert source
        pq.add(new long[]{0, S});

        /*
         * Dijkstra Algorithm
         */
        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            long currentDistance = current[0];

            int u = (int) current[1];

            /*
             * Ignore outdated entries
             */
            if (currentDistance != dist[u]) {
                continue;
            }

            /*
             * Visit all neighbors
             */
            for (E edge : g[u]) {

                /*
                 * Relaxation
                 *
                 * If a shorter path is found
                 */
                if (dist[edge.v] > currentDistance + edge.w) {

                    dist[edge.v] =
                            currentDistance + edge.w;

                    /*
                     * Push updated distance
                     */
                    pq.add(
                            new long[]{
                                    dist[edge.v],
                                    edge.v
                            }
                    );
                }
            }
        }

        /*
         * Print shortest distances
         */
        for (long d : dist) {

            if (d == INF)
                System.out.print("-1 ");
            else
                System.out.print(d + " ");
        }
    }
}