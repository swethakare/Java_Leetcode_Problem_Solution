class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    public int helper(String s, String t, int i, int j, int[][] dp) {
        // Base case: if either string is exhausted
        if (i < 0) {
            return j + 1; // All remaining characters of t need to be inserted
        }
        if (j < 0) {
            return i + 1; // All remaining characters of s need to be deleted
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // If characters are the same, no operation needed; move to the next characters
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = helper(s, t, i - 1, j - 1,dp);
        } else {
            // Compute the minimum operations by considering insertion, deletion, and substitution
            int insert = helper(s, t, i, j - 1,dp);
            int delete = helper(s, t, i - 1, j,dp);
            int replace = helper(s, t, i - 1, j - 1,dp);
            dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
        return dp[i][j];
    }
}
