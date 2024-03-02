import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(dp, n);
    }

    public int helper(int[] dp, int n) {
        if (n == 0) {
            dp[n] = 1; // There is one way to climb 0 stairs, i.e., do nothing.
            return dp[n];
        } else if (n == 1) {
            dp[n] = 1; // There is one way to climb 1 stair, i.e., take one step.
            return dp[n];
        }
        if (dp[n] == -1) {
        
            dp[n] = helper(dp,n-1) + helper(dp,n-2);
        }
        return dp[n];
    }
}
