class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = "";
        for(int i = s.length()-1; i >= 0; i--){
            t = t + s.charAt(i);
        }
        int[][] dp = new int[s.length()+1][t.length()+1];
        return helper(s,t,dp);
    }
    public int helper(String s, String t, int[][] dp){
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0 + Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}