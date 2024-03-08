class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        boolean zero = false;
        int zerocnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                mul = mul * nums[i];
            }else{
                zero = true;
                zerocnt++;
            }           
        }
        for(int i = 0 ;i< nums.length; i++){
           if(zero && zerocnt == 1){
               if(nums[i] == 0){
                   nums[i] = mul;
               }else{
                   nums[i] = 0;
               }
           }else if(zero && zerocnt > 1){
               nums[i] = 0;
           }else{
               nums[i] = mul/nums[i];
           }
        }
        return nums;
    }
}