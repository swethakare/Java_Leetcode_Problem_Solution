class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j < amount+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(amount,coins,0,dp);
    }
    int helper(int amount, int[] coins, int ind, int[][] dp){
        if(ind == coins.length-1){
            if(amount == coins[ind]){
                return 1;
            }else if(amount%coins[ind] == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }
        int ntake = helper(amount,coins,ind+1,dp);
        int take = 0;
        if(coins[ind] <= amount){
            take = helper(amount-coins[ind],coins,ind,dp);
            
        }
        dp[ind][amount] = take+ntake;
        return dp[ind][amount];
    }
}