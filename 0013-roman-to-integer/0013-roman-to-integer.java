class Solution {
    public int romanToInt(String s) {

        HashMap<String,Integer> mp = new HashMap<String,Integer>();
        mp.put("I",1);
        mp.put("V",5);
        mp.put("X",10);
        mp.put("L",50);
        mp.put("C",100);
        mp.put("D",500);
        mp.put("M",1000);
        mp.put("CM",900);
        mp.put("XC",90);
        mp.put("IX",9);
        mp.put("IV",4);
        mp.put("XL",40);
        mp.put("XC",90);
        mp.put("CD",400);
        
        int sum = 0;
        int i = 0;
        int a = 0 ;
        while(i < s.length()){
            if(i+1 < s.length() && mp.containsKey(String.valueOf(s.substring(i,i+2)))){
                a = mp.get(String.valueOf(s.substring(i,i+2)));
                sum = sum + a;
                i += 2;
            }else{
                a = mp.get(String.valueOf(s.charAt(i)));
                sum = sum + a;
                i++;
            }
        }
        return sum;
    }
}