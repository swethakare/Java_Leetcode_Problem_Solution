class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(prices,0,fee,1,dp);
    }
    int helper(int[] prices, int ind, int fee, int buy, int[][] dp){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + helper(prices, ind+1, fee, 0,dp) , helper(prices,ind+1,fee,1,dp));
        }else{
            profit = Math.max(prices[ind] - fee + helper(prices, ind+1, fee, 1,dp), helper(prices,ind+1,fee,0,dp));
        }
        return dp[ind][buy] = profit;
    }
}