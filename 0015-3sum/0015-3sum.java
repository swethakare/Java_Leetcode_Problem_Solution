class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ar = new ArrayList<>();
        int j  = 0 ; 
        int k = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            j = i + 1;
            k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ar.add(Arrays.asList(nums[i],nums[j],nums[k]));

                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while(k<nums.length-2 && nums[k]==nums[k+1]){
                        k--;
                    }
                    j++;
                    k--;

                }else if(sum < 0){
                    j++;
                }else if(sum >0){
                    k--;
                }
            }
        }
        return ar;
    }
}