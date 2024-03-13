class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuffer sb = new StringBuffer();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            String st = String.valueOf(s.charAt(i));
            int index = sb.indexOf(st);
            if (index == -1) {
                sb.append(st);
                len = Math.max(len, sb.length());
            } else {
                sb.delete(0, index+1);
                sb.append(st);
            }
        }
        return len;
    }
}
