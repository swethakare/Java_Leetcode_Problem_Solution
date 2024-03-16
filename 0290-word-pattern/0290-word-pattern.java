import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> mp = new HashMap<>();
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        for(int i = 0 ; i < pattern.length(); i++){
            char a = pattern.charAt(i);
            String b = words[i];
            if(mp.containsKey(a)){
                if(!mp.get(a).equals(b)){
                    return false;
                }
            }else{
                if(mp.containsValue(b)){
                    return false;
                }
                mp.put(a,b);
            }
        }
        return true;
    }
}
        