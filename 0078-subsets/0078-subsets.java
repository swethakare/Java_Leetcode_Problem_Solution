class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> subset = new ArrayList<>();
        List<Integer> item = new ArrayList<Integer>();
        return helper(0, nums, subset, item, nums.length);
 
        
    }
    public List<List<Integer>> helper(int ind, int [] nums, List<List<Integer>> subset, List<Integer> item, int N){
        if(ind == N){
            subset.add(new ArrayList<>(item));
            return subset;
        }
        item.add(nums[ind]);
        helper(ind+1, nums, subset, item, N);
        item.remove(item.size()-1);
        helper(ind+1, nums, subset, item, N);
        return subset;
        
    }
}