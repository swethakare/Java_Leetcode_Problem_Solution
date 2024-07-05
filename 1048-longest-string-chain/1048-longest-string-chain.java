import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1); // Initialize dp array with 1 because each word is at least a chain of length 1
        
        int maxlen = 1;
        
        for (int i = 0; i < words.length; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (words[prev].length() + 1 == words[i].length() && isPredecessor(words[prev], words[i])) {
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        
        return maxlen;
    }
    
    private boolean isPredecessor(String s, String t) {
    int i = 0, j = 0;
    int cnt = 0;
    while (i < s.length() && j < t.length()) {
        if (s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        } else {
            j++;
            cnt++;
        }
    }
    // Count remaining characters in t
    cnt += t.length() - j;

    return cnt == 1;
}

}
