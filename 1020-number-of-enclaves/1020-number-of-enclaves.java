import java.util.*;

class item {
    int x, y;
    
    item(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        Queue<item> q = new LinkedList<item>();
        int ilcnt = 0;

        // Handle edge cases when grid has only one row or one column
        if(grid.length == 1 || grid[0].length == 1){
            return 0;
        }

        // Explore border cells and mark reachable cells
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                bfs(grid, vis, q, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                bfs(grid, vis, q, i, grid[0].length - 1);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                bfs(grid, vis, q, 0, i);
            }
            if (grid[grid.length - 1][i] == 1) {
                bfs(grid, vis, q, grid.length - 1, i);
            }
        }

        // Mark reachable cells using BFS
        while (!q.isEmpty()) {
            item it = q.poll();
            bfs(grid, vis, q, it.x, it.y);
        }

        // Calculate enclave count
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    ilcnt++;
                }
            }
        }
        return ilcnt;
    }

    // BFS to mark reachable cells
    private void bfs(int[][] grid, int[][] vis, Queue<item> q, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        q.add(new item(x, y));
        vis[x][y] = 1;
        while (!q.isEmpty()) {
            item it = q.poll();
            int row = it.x;
            int col = it.y;
            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new item(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}
