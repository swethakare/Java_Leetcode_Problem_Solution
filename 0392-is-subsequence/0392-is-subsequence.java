class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        if(s.length() > t.length()){
            return false;
        }
        while(j < s.length() && i < t.length()){
            if(s.charAt(j) == t.charAt(i)){
                j++;
                i++;
            }else{
                i++;
            }
        }
        if(j == s.length()){
            return true;
        }
        return false;
    }
}