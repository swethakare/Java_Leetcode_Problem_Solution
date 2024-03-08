class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int mul = 1;
        // boolean zero = false;
        // int zerocnt = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] != 0){
        //         mul = mul * nums[i];
        //     }else{
        //         zero = true;
        //         zerocnt++;
        //     }           
        // }
        // for(int i = 0 ;i< nums.length; i++){
        //    if(zero && zerocnt == 1){
        //        if(nums[i] == 0){
        //            nums[i] = mul;
        //        }else{
        //            nums[i] = 0;
        //        }
        //    }else if(zero && zerocnt > 1){
        //        nums[i] = 0;
        //    }else{
        //        nums[i] = mul/nums[i];
        //    }
        // }
        // return nums;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for(int i = 1 ; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        right[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i = 0 ; i < nums.length; i++){
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}