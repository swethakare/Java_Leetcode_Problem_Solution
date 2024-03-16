class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mps = new int[200];
        int[] mpt = new int[200];
        for(int i = 0 ; i<s.length(); i++){
            int a = s.charAt(i);
            int b = t.charAt(i);
            if(mps[a] != mpt[b]){
                return false;
            }
            mps[a] = i+1;
            mpt[b] = i+1;
        }
        return true;
                
    }
}