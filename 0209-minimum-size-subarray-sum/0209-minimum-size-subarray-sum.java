class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int j = 0;
        int i = 0;
        while(i< nums.length) {
            sum += nums[i];
            while(sum >= target) {
                len = Math.min(len, i - j + 1);
                sum -= nums[j];
                j++;
               
            }
            i++;
        }
        return len == Integer.MAX_VALUE ? 0 : len ;
    }
}
