class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(!ar.contains(nums[i])){
                ar.add(nums[i]);
            }
        }
        for(int i = 0 ; i < ar.size(); i++){
            nums[i] = ar.get(i);
        }
        return ar.size();
    }
}