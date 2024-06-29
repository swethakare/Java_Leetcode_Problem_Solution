class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(s, p, s.length() - 1, p.length() - 1, dp);
    }

    boolean helper(String s, String p, int i, int j, int[][] dp) {
        // If both string and pattern are exhausted, return true
        if (i < 0 && j < 0) {
            return true;
        }
        // If string is exhausted and pattern is not, check if remaining pattern characters are all '*'
        if (i < 0) {
            for (int l = j; l >= 0; l--) {
                if (p.charAt(l) != '*') {
                    return false;
                }
            }
            return true;
        }
        // If pattern is exhausted and string is not, return false
        if (j < 0) {
            return false;
        }

        // Use memoization to avoid recomputing
        if (dp[i + 1][j + 1] != -1) {
            return dp[i + 1][j + 1] == 1;
        }

        boolean match = false;

        // If current characters match or pattern character is '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            match = helper(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j) == '*') {
            // If pattern character is '*', it can match zero or more characters
            match = helper(s, p, i - 1, j, dp) || helper(s, p, i, j - 1, dp);
        }

        dp[i + 1][j + 1] = match ? 1 : 0;

        return match;
    }
}
