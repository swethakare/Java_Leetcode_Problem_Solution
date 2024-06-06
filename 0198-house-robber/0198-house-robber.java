class Solution {
    public int rob(int[] nums) {
        
        
        int [] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums, nums.length-1, dp);
        
    }
    public int helper(int[] nums, int ind, int[] dp){
        if(ind == 0){
            dp[ind] = nums[ind];
            return dp[ind];
        }else if(ind < 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = nums[ind] + helper(nums, ind-2, dp);
        int notpick = 0 + helper(nums, ind-1, dp);
        int max = Math.max(pick, notpick);
        dp[ind] = max;
        return dp[ind];
    }
}