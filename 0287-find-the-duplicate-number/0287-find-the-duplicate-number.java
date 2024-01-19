class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            int nu = nums[i];
            freq[nu] = freq[nu] + 1;
            if(freq[nu] > 1){
                return nums[i];
            }
        }
        return -1;
    }
}
    