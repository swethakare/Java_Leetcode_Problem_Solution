class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        
        // Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0; // Distance to self is 0
        }
        
        // Populate the distance matrix with given edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            distance[from][to] = weight;
            distance[to][from] = weight; // Since it's bidirectional
        }
        
        // Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        
        int minReachableCities = Integer.MAX_VALUE;
        int resultCity = -1;
        
        // Find the city with the smallest number of reachable cities within the distance threshold
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            // If the current city has fewer reachable cities or the same number but a larger index
            if (reachableCities < minReachableCities || 
                (reachableCities == minReachableCities && i > resultCity)) {
                minReachableCities = reachableCities;
                resultCity = i;
            }
        }
        
        return resultCity;
    }
}
