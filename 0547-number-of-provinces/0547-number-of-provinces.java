import java.util.ArrayList;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < isConnected.length; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        // Populate the adjacency list
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }

        int[] visited = new int[isConnected.length];
        int cnt = 0;

        // Perform DFS for each unvisited node
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                cnt++;
                dfs(adjacencyList, visited, i);
            }
        }

        return cnt;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(adj, vis, it);
            }
        }
    }
}
