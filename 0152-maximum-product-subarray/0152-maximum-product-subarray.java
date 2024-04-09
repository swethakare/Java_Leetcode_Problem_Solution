class Solution {
    public int maxProduct(int[] nums) {
        int right = nums.length-1;
        int pre = 1;
        int suf = 1;
        int max = Integer.MIN_VALUE;
        for(int left = 0; left < nums.length; left++){
            if(pre == 0){
                pre = 1;
            }
            if(suf == 0){
                suf = 1;
            }
            pre *= nums[left];
            suf *= nums[right];
            right--;
            max = Math.max(max,Math.max(pre,suf));
        }
        return max;

    }
}
