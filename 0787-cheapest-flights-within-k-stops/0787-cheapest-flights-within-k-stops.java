import java.util.*;

class Item {
    int node;
    int cost;
    
    public Item(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create adjacency list to represent flights
        List<List<Item>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Item(flight[1], flight[2]));
        }

        // Initialize distance array to store minimum cost to reach each node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // BFS traversal with at most k stops
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(src, 0));
        
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Item current = queue.poll();
                int node = current.node;
                int cost = current.cost;

                // Explore neighbors
                for (Item neighbor : adj.get(node)) {
                    int nextNode = neighbor.node;
                    int nextCost = cost + neighbor.cost;

                    // Update distance if a cheaper path is found
                    if (nextCost < dist[nextNode]) {
                        dist[nextNode] = nextCost;
                        queue.offer(new Item(nextNode, nextCost));
                    }
                }
            }
            k--; // Decrement k to keep track of number of stops
        }

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }
}
