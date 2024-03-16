class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> mps = new HashMap<>();
        HashMap<Character, Integer> mpt = new HashMap<>();
        for(int i = 0 ; i < s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(!mps.containsKey(a)){
                mps.put(a,i);
            }
            if(!mpt.containsKey(b)){
                mpt.put(b,i);
            }
            if(mps.get(a) != mpt.get(b)){
                return false;
            }
        }
        return true;
    }
}
        