class item {
    int node;
    int cost;
    
    item(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<item> q = new LinkedList<>();
        List<List<item>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<item>());
        }
        
        // Populate adjacency list
        for(int i = 0; i < times.length; i++){
            adj.get(times[i][0]).add(new item(times[i][1],times[i][2]));
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Add source node k to the queue
        q.add(new item(k, 0));
        dist[k] = 0;
        
        while (!q.isEmpty()) {
            item it = q.poll();
            int curnode = it.node;
            int curcost = it.cost;
             
            for (item neigh : adj.get(curnode)) {
                int neinode = neigh.node;
                int neicost = neigh.cost;
                
                if (curcost + neicost < dist[neinode]) {
                    dist[neinode] = curcost + neicost;
                    q.add(new item(neinode, curcost + neicost));
                }
            }
        }
        int max = -1;
        for(int i = 1 ; i < dist.length; i++){
            max = Math.max(max,dist[i]);
        }
        
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}