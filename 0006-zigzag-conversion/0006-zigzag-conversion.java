class Solution {
    public String convert(String s, int numRows) {
        StringBuffer sb[] = new StringBuffer [numRows];
        for(int i = 0 ; i<numRows; i++){
            sb[i] = new StringBuffer();
        }
        char ch[] = s.toCharArray();
        int j = 0 ;
        while(j < s.length()){
            for(int idx = 0; idx < numRows && j < ch.length; idx++){
                sb[idx].append(ch[j]);
                j++;
            }
            for(int idx = numRows-2; idx > 0 && j < ch.length; idx--){
                sb[idx].append(ch[j]);
                j++;
            }
        }
      for(int i = 1; i < numRows; i++){
          sb[0].append(sb[i]);
      }
        return sb[0].toString();
    }
}