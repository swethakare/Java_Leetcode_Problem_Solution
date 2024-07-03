class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int i = 0; i < nums.length; i++){
            for(int j  = 0; j < nums.length+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(nums,0,-1,dp);
        
    }
    int helper(int[] nums, int ind, int prevind, int[][] dp){
        if(ind == nums.length){
            return 0;
        } 
        if(dp[ind][prevind+1] != -1){
            return dp[ind][prevind+1];
        }
        int ntake = 0 + helper(nums,ind+1,prevind,dp);
        int take = 0;
        if(prevind == -1 || nums[prevind] < nums[ind]){
            take = 1 + helper(nums,ind+1,ind,dp);
        }
        dp[ind][prevind+1] = Math.max(take,ntake);
        return dp[ind][prevind+1];
    }
}