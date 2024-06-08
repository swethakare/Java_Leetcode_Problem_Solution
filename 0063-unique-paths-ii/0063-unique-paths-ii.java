class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        return helper(dp, row-1, col-1,obstacleGrid);
    }
    int helper(int[][] dp,int row, int col, int[][] gr){
        if(row == 0 && col == 0 && gr[row][col] != 1){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = 0;
        if(row-1 >= 0 && gr[row-1][col] == 0){
            up = helper(dp,row-1, col, gr);
        }
        int left = 0;
        if(col-1 >= 0 && gr[row][col-1] == 0){
            left = helper(dp, row, col-1, gr);
        }
        dp[row][col] = up + left;
        return dp[row][col];
    }
}