class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int len = nums.length-1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j] != 0){
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
        // Arrays.sort(nums);
        return;
        
    }
}