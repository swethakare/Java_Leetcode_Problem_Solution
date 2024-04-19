class item{
    int x, y, d;
    item(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] dis = new int[mat.length][mat[0].length];
        boolean [][] vis = new boolean[mat.length][mat[0].length];
        Queue<item> q = new LinkedList<>();
        for(int i = 0 ; i< mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if(mat[i][j]==0){
                    dis[i][j] = 0;
                    q.add(new item(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        while(!q.isEmpty()){
            item it = q.poll();
            int row = it.x;
            int col = it.y;
            int dist = it.d;
            for(int i = 0; i < 4; i++){
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if(nrow >= 0 && ncol >= 0 && nrow<mat.length && ncol < mat[0].length && vis[nrow][ncol] == false){
                    dis[nrow][ncol] = dist+1;
                    vis[nrow][ncol] = true;
                    q.add(new item(nrow,ncol,dist+1));
                }
            }
        }
        return dis;
    }
}