import java.util.Arrays;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return helper(dp, cost.length, cost);
    }

    public int helper(int[] dp, int n, int[] cost) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int lef = helper(dp, n - 1, cost) + cost[n - 1];
        int rig = helper(dp, n - 2, cost) + cost[n - 2];
        
        dp[n] = Math.min(lef, rig);
        return dp[n];
    }
}
