class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt1 = 0;
        int max = Integer.MIN_VALUE;
        for(int num :  nums){
            if(num == 1){
                cnt1++;
            }else{
                cnt1=0;
            }
            max = Math.max(max, cnt1);
        }
        return max;
        
    }
}