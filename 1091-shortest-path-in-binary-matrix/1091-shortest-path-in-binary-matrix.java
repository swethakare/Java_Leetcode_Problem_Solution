class item{
    int x;
    int y;
    item(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<item> q = new LinkedList<item>();
        int[][] dist = new int[grid.length][grid[0].length];
        if(grid[0][0] != 0){
            return -1;
        }else{
            q.add(new item(0,0));
         
        }
        for(int i = 0; i < dist.length; i++){
            for(int j = 0; j < dist[0].length; j++){
                if(grid[i][j]==0){
                    dist[i][j] = Integer.MAX_VALUE;
                }else{
                    dist[i][j] = -1;
                }
            }
        }
        dist[0][0] = 1;
        int dx[] = {0,-1,1,0,-1,1,-1,1};
        int dy[] = {-1,0,0,+1,-1,+1,+1,-1};
        while(!q.isEmpty()){
            item ite = q.poll();
            int row = ite.x;
            int col = ite.y;
            for(int i = 0; i < 8; i++){
                int newrow = row + dx[i];
                int newcol = col + dy[i];
                if(newrow >= 0 && newcol >= 0 && newrow < grid.length && newcol < grid[0].length && grid[newrow][newcol] == 0){
                    if(dist[row][col] + 1 < dist[newrow][newcol]){
                        q.add(new item(newrow,newcol));
                        dist[newrow][newcol] = dist[row][col]+1;
                    }    
                }
            }
        }
        return dist[grid.length-1][grid[0].length-1] == Integer.MAX_VALUE ? -1 : dist[grid.length-1][grid[0].length-1];
    }
}