class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        String [] s1 = new String[text1.length()+1];
        String[] s2 = new String[text2.length()+1];
        int j = 0;
        for(int i = 1; i < s1.length; i++){
            s1[i] = String.valueOf(text1.charAt(j));
            j++;
        }
        j = 0;
        for(int i = 1; i < s2.length; i++){
            s2[i] = String.valueOf(text2.charAt(j));
            j++;
        }
        
        dp = helper(s1,s2,dp,s1.length,s2.length);
        System.out.println(print(s1,s2,s1.length,s2.length,dp));
        return dp[dp.length-1][dp[0].length-1];
    
    }
    public int[][] helper(String[] s1, String[] s2, int[][] dp, int l, int m){
        
        for(int i = 1; i < l; i++){
            for(int j = 1; j < m; j++){
                if((s1[i]).equals(s2[j])){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
            }
        }

        return dp;
   
        
    }
    String print(String[] s1, String[] s2, int l, int m,int[][] dp){
      StringBuilder str = new StringBuilder();
        int i = l-1;
        int j = m-1;
        while(i> 0 && j > 0){
                if((s1[i]).equals(s2[j])){
                    str = str.append(s1[i]);
                    i--;
                    j--;
                }else if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
        }
        return String.valueOf(str.reverse());
    }

}
       