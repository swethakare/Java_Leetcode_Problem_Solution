class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        int up = path(dp,0, 0, m, n);
        return up;
    
    }
    public int path(int[][] dp, int row, int col, int m, int n){
        if(row == m || col == n){
            return 0;
        }else if(row == m-1 && col == n-1){
            return 1;
        }else if(dp[row][col] != 0){
            return dp[row][col];
        }
        int left = path(dp, row+1, col, m, n);
        int right = path(dp ,row, col+1, m, n);
        
        dp[row][col] = left + right;
        return dp[row][col];
    }

}