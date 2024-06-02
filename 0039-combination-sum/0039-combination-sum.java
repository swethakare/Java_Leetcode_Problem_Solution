class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> br = new ArrayList<>();
        List<Integer> ar = new ArrayList<Integer>();
        return helper(0, candidates, target, br, ar);
    }
    public List<List<Integer>> helper(int ind, int[] candidates, int target, List<List<Integer>> br, List<Integer> ar){
        if(ind == candidates.length){
            if(target == 0){
                br.add(new ArrayList<Integer>(ar));
            }
            return br;
        }
        if(target < 0){
            return br;
        }
        ar.add(candidates[ind]);
        helper(ind, candidates, target-candidates[ind], br, ar); 
        ar.remove(ar.size()-1);
        helper(ind+1, candidates, target, br, ar);
        return br;
    }
}