class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int withoutlast = helper(nums, nums.length-2, dp);// sending without the last element;
        int[] newnums = new int[nums.length-1];
        int j = 0;
        for(int i = 1; i< nums.length; i++){
            newnums[j] = nums[i];
            j++;
        }
        Arrays.fill(dp,-1);
        int withoutfirst = helper(newnums, newnums.length-1, dp);
        int item = Math.max(withoutlast, withoutfirst);
        
        return item;
        
    }
    public int helper(int[] nums, int ind, int[] dp){
        if(ind == 0){
            return nums[ind];
        }
        if(ind < 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        
        int pick = nums[ind] + helper(nums, ind-2, dp);
        int notpick = 0 + helper(nums,ind-1, dp);
        int max = Math.max(pick, notpick);
        dp[ind] = max;
        return dp[ind];
    }
}