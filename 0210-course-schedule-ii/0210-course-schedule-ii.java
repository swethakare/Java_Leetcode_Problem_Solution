import java.util.ArrayList;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = adjlist(numCourses, prerequisites);
        ArrayList<Integer> ar = new ArrayList<>();
        int[] vis = new int[numCourses];
        int[] pathvis = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (!dfs(vis, pathvis, adj, i, ar)) {
                    return new int[0]; // Cycle detected, return empty array
                }
            }
        }
        
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = ar.get(i);
        }
        return result;
    }
    
    public boolean dfs(int[] vis, int[] pathvis, ArrayList<ArrayList<Integer>> adj, int node, ArrayList<Integer> ar) {
        vis[node] = 1;
        pathvis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (!dfs(vis, pathvis, adj, it, ar)) {
                    return false;
                }
            } else if (pathvis[it] == 1) {
                return false; // Cycle detected
            }
        }
        pathvis[node] = 0;
        ar.add(0, node); // Add the current course to the beginning of the list
        return true;
    }
    
    public ArrayList<ArrayList<Integer>> adjlist(int v, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int pos = prerequisite[1];
            int item = prerequisite[0];
            ArrayList<Integer> ar = adj.get(pos);
            ar.add(item);
            adj.set(pos, ar);
        }
        return adj;
    }
}
