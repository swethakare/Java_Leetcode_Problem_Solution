class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean contains1 = false;
        int n = nums.length;
        for(int i = 0 ; i< nums.length; i++){
            if(nums[i] == 1){
                contains1 = true;
            }else if(nums[i] > n){
                nums[i] = 1;
            }else if(nums[i] <= 0){
                nums[i] = 1;
            }            
        }
        
        if(!contains1){
            return 1;
        }
        
        int value = 0;
        for(int i = 0 ; i < nums.length; i++){
            value = Math.abs(nums[i]);
            if(value == n){
                nums[0] = - Math.abs(nums[0]);
            }else{
                nums[value] = - Math.abs(nums[value]);
            }
        }
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        
        if(nums[0] > 0){
            return n;
            
        }
        
        return n + 1;

        
    }
}