class Solution {
    public int coinChange(int[] coins, int amount) {
      int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j < amount+1; j++){
                dp[i][j] = -1;
            }
        }
      int ite = helper(coins, amount, 0,dp);
      if(ite == (int) 1e9){
          return -1;
      }else{
          return ite;
      }
    }
    public int helper(int[] coins, int amount, int ind, int[][] dp){
        if(ind == coins.length-1){
            if(amount == coins[ind]){
                return 1;
            }else if(amount % coins[ind] == 0){
                return amount/coins[ind];
            }else{
                return (int)1e9;
            }
        }
        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }
        int ntake = 0 + helper(coins,amount,ind+1,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= amount){
             take = 1 + helper(coins,amount-coins[ind],ind,dp);
        }
        dp[ind][amount] = Math.min(take,ntake);
        return dp[ind][amount];
    }
}
        