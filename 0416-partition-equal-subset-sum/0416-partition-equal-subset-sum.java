class Solution {
    public boolean canPartition(int[] nums) {
        int tot = 0;
        for (int num : nums) {
            tot += num;
        }
        if (tot % 2 != 0) {
            return false;
        }
        int target = tot / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(target, nums, 0, dp) == 1;
    }

    public int helper(int target, int[] nums, int ind, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (ind >= nums.length) {
            return 0;
        }
        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int notTaken = helper(target, nums, ind + 1, dp);
        int taken = 0;
        if (nums[ind] <= target) {
            taken = helper(target - nums[ind], nums, ind + 1, dp);
        }

        if (taken == 1 || notTaken == 1) {
            dp[ind][target] = 1;
        } else {
            dp[ind][target] = 0;
        }
        return dp[ind][target];
    }
}
