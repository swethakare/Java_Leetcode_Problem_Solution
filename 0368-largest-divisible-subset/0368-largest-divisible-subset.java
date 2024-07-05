

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[]dp = new int[nums.length];
        int[] hash = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        int maxlen = 1;
        int lastind = 0;
        List<Integer> ar = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            for(int prev = 0; prev<i; prev++){
                if(nums[i]%nums[prev] == 0){
                    if(dp[prev] + 1 > dp[i]){
                        dp[i] = dp[prev]+1;
                        hash[i] = prev;
                    }
                }

                
            }
            if(maxlen < dp[i]){
                    maxlen = dp[i];
                    lastind = i;
                }
        }
        for(int i = lastind ;i >= 0; i=hash[i]){
            ar.add(nums[i]);
            if(hash[i] == -1){
                break;
            }
        }
        return ar;
    }
}
       