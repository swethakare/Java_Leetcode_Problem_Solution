class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if(a[0] != b[0]){
                   return a[0] - b[0];
               }else{
                   return a[1] - b[1];
               }
           } 
        });
        int[][]ans = helper(intervals,ar);
        return ans;
    }
    public int[][] helper(int[][] intervals, ArrayList<ArrayList<Integer>> ar){
        int start = intervals[0][0];
        int end = intervals[0][1];
        ar.add(new ArrayList<>(Arrays.asList(start,end)));
        int j  = 0;
        for(int i = 1; i < intervals.length; i++){
            if(ar.get(j).get(1) >= intervals[i][0]){
                end = ar.get(j).get(1);
                ar.get(j).set(1,Math.max(end,intervals[i][1]));
            }else{
                start = intervals[i][0];
                end = intervals[i][1];
                ar.add(new ArrayList<>(Arrays.asList(start,end)));
                j++;
            }
        }
        int[][] ans = new int[ar.size()][ar.get(0).size()];
        for(int i = 0; i<ar.size(); i++){
            for(int k = 0; k<ar.get(0).size(); k++){
                ans[i][k] = ar.get(i).get(k);
            }
        }
        return ans;
    }
}
