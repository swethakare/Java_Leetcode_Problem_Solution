class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        // int right = nums.length - 1;
        for(int i =0; i<nums.length-1;i++){
            for(int j = i+1; j<nums.length; j++){
                int sum = Math.abs(nums[i] - nums[j]);
                if(sum == k){
                    count++;
                }
            }
        }
        return count; 
    }
}