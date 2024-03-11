class Solution {
    public String convert(String s, int numRows) {
        char[] str = new char[numRows];
        int i = 0;
        int len = s.length();
        char[] ch = s.toCharArray();
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int l = 0 ; l< numRows; l++) sb[l] = new StringBuffer();
        
        while(i < len){
            for(int idx = 0; idx < numRows && i < len; idx++){
                sb[idx].append(ch[i++]);
            }
            for(int idx = numRows-2; idx > 0 && i < len; idx--){
                sb[idx].append(ch[i++]);
            }
        }
        
        for(int j = 1; j < sb.length; j++){
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
        
    }
}