class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<Integer>();
        
        helper(0,target,ar,ds,candidates,candidates.length);
        return ar;

}
    public void helper(int idx, int target, List<List<Integer>> ar, ArrayList<Integer> ds, int[] arr, int n){
        if(idx == n){
            if(target == 0){
                ar.add(new ArrayList<Integer>(ds));
            }
            return;
        }
        
        if(arr[idx] <= target){
            ds.add(arr[idx]);
            helper(idx,target-arr[idx],ar,ds,arr,n);
            ds.remove(ds.size()-1);
            
        }
        helper(idx+1,target,ar,ds,arr,n);
        
    }
}