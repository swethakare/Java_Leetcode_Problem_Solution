class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adj.get(course).add(prereq);
        }

        // Track visited and visiting states of each course
        int[] visited = new int[numCourses];

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(adj, visited, i)) {
                return false; // Cycle detected
            }
        }

        return true; // No cycle detected
    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int[] visited, int course) {
        if (visited[course] == 1) {
            return true; // Cycle detected
        }
        if (visited[course] == 2) {
            return false; // Already visited, no cycle
        }

        visited[course] = 1; // Mark visiting
        for (int neighbor : adj.get(course)) {
            if (hasCycle(adj, visited, neighbor)) {
                return true; // Cycle detected in neighbor
            }
        }
        visited[course] = 2; // Mark visited
        return false; // No cycle detected
    }
}