class Solution {
    public String reformat(String s) {
        int n = 0;
        int c = 0;
        StringBuffer nums = new StringBuffer();
        StringBuffer character = new StringBuffer();
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                nums.append(s.charAt(i));
                n++;
            }else{
                character.append(s.charAt(i));
                c++;
            }
        }
        String op = "";
        if(n==c){
            for(int i = 0 ; i < nums.length(); i++){
                op = op + String.valueOf(nums.charAt(i));
                op = op + String.valueOf(character.charAt(i));
                
            }
        }else if(n+1 == c){
            for(int i = 0 ; i < nums.length(); i++){
               
                op = op + String.valueOf(character.charAt(i));
                op = op + String.valueOf(nums.charAt(i));
            }
            op += String.valueOf(character.charAt(character.length()-1));
            
        }else if(c+1 == n){
            for(int i = 0 ; i < character.length(); i++){
                op = op + String.valueOf(nums.charAt(i));
                op = op + String.valueOf(character.charAt(i));
               
            }
            op += String.valueOf(nums.charAt(nums.length()-1));
            
        }
        return op;
        
    }
}