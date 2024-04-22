class item{
    int x, y;
    item(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        
        int[][] vis = new int[grid.length][grid[0].length];
        
        Queue<item> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new item(i,j));
                    cnt = bfs(vis, grid,q,cnt);
                }
            }
        }
        return cnt;
    }
    public int bfs(int[][] vis, char[][] grid, Queue<item> q, int cnt){
        int [] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1};
        cnt++;
        while(!q.isEmpty()){
            item it = q.poll();
            int row = it.x;
            int col = it.y;
            for(int i = 0; i < 4; i++){
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                    vis[nrow][ncol] = 1;
                    q.add(new item(nrow,ncol));
                    
                }
            }    
        }
        return cnt;
    }
}