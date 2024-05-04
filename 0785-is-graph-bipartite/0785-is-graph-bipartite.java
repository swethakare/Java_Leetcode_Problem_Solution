class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                q.add(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int neighbor : adj.get(node)) {
                        if (color[neighbor] == 0) {
                            color[neighbor] = -color[node];
                            q.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
