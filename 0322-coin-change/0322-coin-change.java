class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
// amount+1 because we need to check the no of minimal ways to make the target with each and every coing ; target+1 array will have the index upto targether
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                   // System.out.println(dp[i]);
                if(dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                    // System.out.println("coin "+coin +" iteration "+i+" "+ dp[i]);
                }
            }
        }
        return dp[dp.length-1] == Integer.MAX_VALUE ? -1 : dp[dp.length-1];
    }
}

// wlakthrough:
// coin 1 iteration 1 1
// coin 1 iteration 2 2
// coin 1 iteration 3 3
// coin 1 iteration 4 4
// coin 1 iteration 5 5
// coin 1 iteration 6 6
// coin 1 iteration 7 7
// coin 1 iteration 8 8
// coin 1 iteration 9 9
// coin 1 iteration 10 10
// coin 1 iteration 11 11
// coin 2 iteration 2 1
// coin 2 iteration 3 2
// coin 2 iteration 4 2
// coin 2 iteration 5 3
// coin 2 iteration 6 3
// coin 2 iteration 7 4
// coin 2 iteration 8 4
// coin 2 iteration 9 5
// coin 2 iteration 10 5
// coin 2 iteration 11 6
// coin 5 iteration 5 1
// coin 5 iteration 6 2
// coin 5 iteration 7 2
// coin 5 iteration 8 3
// coin 5 iteration 9 3
// coin 5 iteration 10 2
// coin 5 iteration 11 3
