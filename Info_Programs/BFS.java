import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // Number of vertices
        int n = s.nextInt();

        // Number of edges
        int e = s.nextInt();

        // Adjacency list representation of graph
        List<Integer>[] g = new ArrayList[n + 1];

        // Initialize all adjacency lists
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        // Read all edges
        while (e-- > 0) {

            int a = s.nextInt();
            int b = s.nextInt();

            // Undirected graph
            g[a].add(b);
            g[b].add(a);
        }

        // Source vertex
        int S = s.nextInt();

        // Destination vertex
        int D = s.nextInt();

        /*
         * Distance array
         *
         * dist[i] = shortest distance from source
         *
         * -1 means not visited
         */
        int[] dist = new int[n + 1];

        Arrays.fill(dist, -1);

        // Queue used for BFS
        Queue<Integer> q = new ArrayDeque<>();

        // Start BFS from source node
        q.add(S);

        // Distance from source to itself is 0
        dist[S] = 0;

        while (!q.isEmpty()) {

            // Remove front node
            int u = q.poll();

            // Visit all neighbors
            for (int v : g[u]) {

                // Visit only unvisited nodes
                if (dist[v] < 0) {

                    // Distance increases by one edge
                    dist[v] = dist[u] + 1;

                    // Add neighbor for future processing
                    q.add(v);
                }
            }
        }

        // Shortest distance from S to D
        System.out.println(dist[D]);
    }
}