class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        Arrays.sort(intervals,Comparator.comparingInt(inter->inter[0]));
        row.add(intervals[0][0]);
        row.add(intervals[0][1]);
        ar.add(row);
        
        for(int i = 1; i < intervals.length; i++) {
            int start = ar.get(ar.size() - 1).get(0);
            int end = ar.get(ar.size() - 1).get(1);
            int nextstart = intervals[i][0];
            int nextend = intervals[i][1];
            
            if(nextstart <= end) {
                ar.get(ar.size() - 1).set(1,Math.max(end,nextend));
            } else {
                ArrayList<Integer> newRow = new ArrayList<>();
                newRow.add(nextstart);
                newRow.add(nextend);
                ar.add(newRow);
            }
        }
        
        int[][] result = new int[ar.size()][2];
        for(int i = 0; i < ar.size(); i++) {
            result[i][0] = ar.get(i).get(0);
            result[i][1] = ar.get(i).get(1);
        }
        
        return result;
    }
}
