class Solution {
    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];
        if(board.length == 1 && board[0].length == 1){
            return;
        }
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                dfs(vis,board,0,i);
            }
            if(board[board.length-1][i]=='O'){
                dfs(vis,board,board.length-1,i);
            }
        }
        for(int i = 0; i< board.length; i++){
            if(board[i][0] == 'O'){
                dfs(vis,board,i,0);
            }
            if(board[i][board[0].length-1]=='O'){
                dfs(vis,board,i,board[0].length-1);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
    public void dfs(int[][] vis, char[][] board, int x,int y){
        vis[x][y] = 1;
        int [] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        
        for(int i = 0; i < 4; i++){
            int nrow = x + dx[i];
            int ncol = y + dy[i];
            if(nrow >= 0 && ncol >= 0 && nrow < board.length && ncol < board[0].length && vis[nrow][ncol] == 0 && board[nrow][ncol]=='O'){
                dfs(vis,board,nrow,ncol);
            }
        }
    }
}