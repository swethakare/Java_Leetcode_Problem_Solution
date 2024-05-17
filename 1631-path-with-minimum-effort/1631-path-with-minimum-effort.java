class item {
    int x;
    int y;
    int diff;
    
    item(int x, int y, int diff) {
        this.x = x;
        this.y = y;
        this.diff = diff;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dist = new int[heights.length][heights[0].length];
        PriorityQueue<item> q = new PriorityQueue<>((a, b) -> Integer.compare(a.diff, b.diff));
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        
        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        dist[0][0] = 0;
        q.add(new item(0, 0, 0));
        
        while (!q.isEmpty()) {
            item it = q.poll();
            int row = it.x;
            int col = it.y;
            
            if (row == heights.length - 1 && col == heights[0].length - 1) {
                return dist[row][col];
            }
            
            for (int i = 0; i < 4; i++) {
                int newrow = row + dx[i];
                int newcol = col + dy[i];
                
                if (newrow >= 0 && newcol >= 0 && newrow < heights.length && newcol < heights[0].length) {
                    int newDiff = Math.max(it.diff, Math.abs(heights[row][col] - heights[newrow][newcol]));
                    
                    if (newDiff < dist[newrow][newcol]) {
                        q.add(new item(newrow, newcol, newDiff));
                        dist[newrow][newcol] = newDiff;
                    }
                }
            }
        }

        return -1; // Error case if no path is found
    }
}
