class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        
        // Initialize dp array
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l <= k; l++) { // should be l <= k
                    dp[i][j][l] = -1;
                }
            }
        }
        
        return helper(prices, 0, 1, k, dp);
    }
    
    int helper(int[] prices, int ind, int buy, int cap, int[][][] dp) {
        // Base case
        if (ind >= prices.length || cap == 0) {
            return 0;
        }
        
        // Memoization check
        if (dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }
        
        int profit = 0;
        
        if (buy == 1) {
            // Buy scenario
            profit = Math.max(-prices[ind] + helper(prices, ind + 1, 0, cap, dp), helper(prices, ind + 1, 1, cap, dp));
        } else {
            // Sell scenario
            profit = Math.max(prices[ind] + helper(prices, ind + 1, 1, cap - 1, dp), helper(prices, ind + 1, 0, cap, dp));
        }
        
        // Memoize the result
        return dp[ind][buy][cap] = profit;
    }
}
