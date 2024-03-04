class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int prefixsum = 0;
        int avlidx = -1;
        int remain = 0;
        int res = 0;
        for(int i = 0; i< nums.length; i++){
            prefixsum = prefixsum + nums[i];
            remain = prefixsum - target;
            if(mp.containsKey(remain) && mp.get(remain) >= avlidx){
                res++;
                avlidx = i;
            }
            mp.put(prefixsum,i);
                
        }
        return res;
        
    }
}