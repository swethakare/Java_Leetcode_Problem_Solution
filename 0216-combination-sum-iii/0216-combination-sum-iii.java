class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[9];
        arr[0] = 1;
        for(int i = 1;i < 9;i++){
            arr[i] = arr[i-1]+1;
        }
        ArrayList<Integer> ds = new ArrayList<Integer>();
        List<List<Integer>> ar = new ArrayList<>();
        helper(0,k,arr,n,ds,ar);
        return ar;
    }
    public void helper(int i, int size,int[] arr, int target, ArrayList<Integer> ds, List<List<Integer>> ar){
        if(target == 0){
            if(size == ds.size()){
                ar.add(new ArrayList<Integer>(ds));
            }
            return;
        }
        if (target < 0 || size < 0 || i >= arr.length) {
            return;
        }
        if(arr[i] <= target){
           ds.add(arr[i]);
           helper(i+1,size,arr,target-arr[i],ds,ar); 
           ds.remove(ds.size()-1);
        }
        helper(i+1,size,arr,target,ds,ar);
    }
}