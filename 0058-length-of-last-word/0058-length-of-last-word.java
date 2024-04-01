class Solution {
    public int lengthOfLastWord(String s) {
        String st = s.trim();
        String[] ar = st.split(" ");
        return ar[ar.length-1].length();
        
    }
}