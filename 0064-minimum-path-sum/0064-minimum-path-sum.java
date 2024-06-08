class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int [grid.length][grid[0].length];
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        int row = grid.length;
        int col = grid[0].length;
        return helper(dp, grid, row-1, col-1);
        
    }
    int helper(int[][] dp, int[][] grid, int row, int col){
        if(row == 0 && col == 0){
            return grid[0][0];
   
        }
        if(row < 0 || col < 0){
             return (int) Math.pow(10, 9); // signifies that it is an invalid path
            // return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int upsum = grid[row][col] + helper(dp,grid,row-1,col);
        int leftsum = grid[row][col] + helper(dp,grid,row, col-1);
        dp[row][col] = Math.min(upsum, leftsum);
        return dp[row][col];
    }
}