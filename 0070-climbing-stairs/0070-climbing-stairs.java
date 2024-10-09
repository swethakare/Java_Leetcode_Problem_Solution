import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }
    public int helper(int[] dp, int n){
        if(n == 0){
            dp[n] = 1; //in combination 0 is a valid case so one way to reach 0
            return dp[n];
        }
        if(n == 1){
            dp[n] = 1;
            return dp[n];
        }
        if(dp[n] == -1){
        dp[n] = helper(dp,n-2) + helper(dp,n-1);
        }
        return dp[n];  
    }
}

//walkthrough;

// from n = 4;
// dp[4] = dp(3) + dp(2);---> 3+2 = 5 --> final answer

// n = 3;
// dp[3] = dp(2)+dp(1);--->2 +1 = 3

// n = 2;
// dp[2] = dp(1)+dp(0); ---> 1+1 = 2

// n=1;
// dp[1] = 1;

// n = 0;
// dp[0] = 1;


      