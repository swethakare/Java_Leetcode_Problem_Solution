class Solution {
    public int maxProfit(int[] prices) {
        
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(prices,0,1,dp);
        
    }
    public int helper(int[] prices,int ind, int buy,int[][] dp){
        if(ind == prices.length){
            return 0;
        }
        int profit = 0;
        if(dp[ind][buy] !=-1){
            return dp[ind][buy];
        }
        if(buy == 1){
             profit = Math.max(-prices[ind] + helper(prices,ind+1,0,dp), 0+ helper(prices,ind+1,1,dp));
        }else{
            profit = Math.max(prices[ind] + helper(prices,ind+1,1,dp),0+helper(prices,ind+1,0,dp)); 
        }
        dp[ind][buy]  = profit;
        return dp[ind][buy];
    }
}