class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0;
        int neg = 1;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i]>0){
                res[pos*2] = nums[i];
                pos++;
            }else{
                res[neg*2-1] = nums[i];
                neg++;
            }
        }
        return res;
   
    }
}