class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList());
        }
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                adj.get(graph[i][j]).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[indeg.length];
        for(int i = 0; i < indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        List<Integer> ar = new ArrayList<>();
        while(!q.isEmpty()){
            int it = q.poll();
            ar.add(it);
            for(int ie : adj.get(it)){
                indeg[ie]--;
                if(indeg[ie] == 0 && vis[ie] == 0){
                    q.add(ie);
                    vis[ie] = 1;
                }
            }
        }
        Collections.sort(ar);
        return ar;
        
    }
}