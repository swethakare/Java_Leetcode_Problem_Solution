class Solution {
    public int lengthOfLastWord(String s) {
        String[] tr = s.split(" ");
        String op = "";
        for(int i = tr.length-1; i >= 0 ; i--){
            if(tr[i] == " "){
                continue;
            }else{
                op = tr[i];
                System.out.println(op);
                break;
            }
        }
        return op.length();
     

    }
}