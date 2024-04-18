class item {
    int x, y, t;

    item(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<item> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];
        int max = -1;
        int fo = 0;
        
        // Adding initial rotten oranges to the queue and marking them as visited
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new item(i, j, 0));
                    vis[i][j] = 1;
                }else if(grid[i][j]==1){
                    fo++;
                }
            }
        }
        if(fo == 0){
            return 0;
        }

        while (!q.isEmpty()) {
            item it = q.poll();
            int t = it.t;
            max = Math.max(t, max);
            int row = it.x;
            int col = it.y;
       
            if (row - 1 >= 0 && grid[row - 1][col] == 1 && vis[row - 1][col] == 0) {
                q.add(new item(row - 1, col, t + 1));
                vis[row - 1][col] = 1;
                fo--;
            }
            if (row + 1 < grid.length && grid[row + 1][col] == 1 && vis[row + 1][col] == 0) {
                q.add(new item(row + 1, col, t + 1));
                vis[row + 1][col] = 1;
                fo--;
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1 && vis[row][col - 1] == 0) {
                q.add(new item(row, col - 1, t + 1));
                vis[row][col - 1] = 1;
                fo--;
            }
            if (col + 1 < grid[0].length && grid[row][col + 1] == 1 && vis[row][col + 1] == 0) {
                q.add(new item(row, col + 1, t + 1));
                vis[row][col + 1] = 1;
                fo--;
            }
        }
        if(fo > 0){
            return -1;
        }else{
            return max;
        }
    }
}
