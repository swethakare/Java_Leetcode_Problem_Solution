class Solution {
    public long countSubarrays(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int maxele =  temp[temp.length-1];
        int cnt = 1 ;
        for(int i = temp.length-1; i > 0; i--){
            if(temp[i] == temp[i-1]){
                cnt++;
            }else{
                break;
            }
        }
       
        if(cnt < k){
            return 0;
        }
        long maxelecnt = 0;
        int left = 0;
        int right = 0;
        long subcnt = 0;
        while(right < temp.length && left < temp.length){
            if(nums[right]== maxele){
                maxelecnt++;
            }
            while(maxelecnt >= k){
                if(nums[left] == maxele){
                    maxelecnt--;
                }
                subcnt += temp.length - right;
                left++;
            }
            right++;
        }
        return subcnt;
    }
}
