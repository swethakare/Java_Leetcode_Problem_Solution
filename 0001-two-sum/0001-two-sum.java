class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        int sum = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            sum = target - nums[i];
            if(mp.containsKey(sum)){
                temp[0] = mp.get(sum);
                temp[1] = i;
                return temp;
            }
            mp.put(nums[i],i);
            
        }
        return temp;
    }
}