class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(nums[0] != 0 ){
            return 0;
        }else if(nums[nums.length-1] != n){
            return n;
        }
        for(int i = 1; i<n; i++){
            if(nums[i-1]+1 != nums[i]){
                return nums[i-1]+1;
            }
        }
        return -1;
    }
}