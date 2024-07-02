class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3 ; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(prices, 0, 1, 2,dp);
    }
    
    int helper(int[] prices, int ind, int buy, int cap,int[][][] dp) {
        if(ind == prices.length || cap == 0){
            return 0;
        }
        if(dp[ind][buy][cap] != -1){
            return dp[ind][buy][cap];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[ind] + helper(prices, ind + 1, 0, cap,dp), helper(prices, ind + 1, 1, cap,dp));
        } else {
            profit = Math.max(prices[ind] + helper(prices, ind + 1, 1, cap - 1,dp), helper(prices, ind + 1, 0, cap,dp));
        }
        
        return dp[ind][buy][cap] = profit;
    }
}
