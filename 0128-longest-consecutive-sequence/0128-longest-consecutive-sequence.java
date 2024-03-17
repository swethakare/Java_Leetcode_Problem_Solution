class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int cnt = 1;
        int max = 1;
        for(int i = 0 ; i < nums.length-1; i++){
            if(nums[i+1] == nums[i]+1){
                cnt++;
                max = Math.max(max,cnt);
            }else if (nums[i] == nums[i+1]){
                cnt = cnt;
            }else{
                cnt = 1;
            }
        }
        return nums.length == 0 ? 0 : max;
        
    }
}