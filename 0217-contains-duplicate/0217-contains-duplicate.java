class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mp = new HashSet<>();
        // ArrayList<Integer> mp = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            if(mp.contains(nums[i])){
                return true;
            }else{
                mp.add(nums[i]);
            }
        }
        return false;
    }
}