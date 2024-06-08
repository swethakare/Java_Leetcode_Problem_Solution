class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(dp,m-1,n-1);
        
    }
    public int helper(int[][] dp, int m, int n){
        if(m== 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up = helper(dp, m-1, n);
        int left = helper(dp, m, n-1);
        
        dp[m][n] = up+left;
        return dp[m][n];
    }
}