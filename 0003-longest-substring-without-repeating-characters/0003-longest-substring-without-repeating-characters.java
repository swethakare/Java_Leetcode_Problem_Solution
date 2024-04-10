class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuffer sb = new StringBuffer();
        int Max = 0;
        for (int right = 0; right < s.length(); right++) {
            String val = String.valueOf(s.charAt(right));
            int index = sb.indexOf(val);
            if(index == -1){
                sb.append(val);
                Max = Math.max(Max, sb.length());
            }else{
                sb.delete(0,index+1);
                sb.append(val);
            }
        }
        return Max;
    }
}
