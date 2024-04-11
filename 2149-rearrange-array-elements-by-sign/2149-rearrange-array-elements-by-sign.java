class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] < 0){
                neg.add(nums[i]);
            }else{
                pos.add(nums[i]);
            }
        }
    
        int k = 0;
        int l = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(i%2 == 0){
                nums[i] = pos.get(k);
                k++;
            }else{
                nums[i] = neg.get(l);
                l++;
            }

        }
        return nums;
    }
}