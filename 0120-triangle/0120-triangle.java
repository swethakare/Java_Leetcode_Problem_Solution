import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        // Initialize dp array with -1 indicating uncalculated cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = -1;
            }
        }
        
        return helper(dp, triangle, 0, 0);
    }
    
    int helper(int[][] dp, List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        
        int down = triangle.get(row).get(col) + helper(dp, triangle, row + 1, col);
        int diag = triangle.get(row).get(col) + helper(dp, triangle, row + 1, col + 1);
        
        dp[row][col] = Math.min(down, diag);
        
        return dp[row][col];
    }
}
