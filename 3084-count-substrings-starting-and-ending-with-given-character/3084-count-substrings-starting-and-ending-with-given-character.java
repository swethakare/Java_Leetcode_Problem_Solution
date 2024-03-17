class Solution {
    public long countSubstrings(String s, char c) {
    //     long startwith = 0;
    //     long notends = 0;
    //     long occ = 0;
    //     for(int i = 0 ; i < s.length(); i++){
    //         if(s.charAt(i) != c){
    //             continue;
    //         }
    //         startwith++;
    //         for(int j = i+1; j<s.length();j++){
    //             startwith++;
    //             if(s.charAt(j) != c){
    //                 notends++;
    //             }
    //         }
    //     }
    //     return startwith - notends;       
    // }
        long cnt = 0;
        for(int i = 0 ;i< s.length(); i++){
            if(s.charAt(i) == c){
                cnt++;
            }
        }
        return cnt * (cnt + 1)/2;
}
}