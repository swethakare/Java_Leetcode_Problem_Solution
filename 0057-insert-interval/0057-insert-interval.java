import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> newinte = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < intervals[i].length; j++) {
                innerList.add(intervals[i][j]);
            }
            newinte.add(innerList);
        }
         ArrayList<Integer> innerList = new ArrayList<>();
         innerList.add(newInterval[0]);
         innerList.add(newInterval[1]);
         newinte.add(innerList);
        Collections.sort(newinte, Comparator.comparingInt(inter -> inter.get(0)));
        return merge(newinte);

    }
    public int[][] merge(ArrayList<ArrayList<Integer>> intervals) {
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        Collections.sort(intervals,Comparator.comparingInt(inter->inter.get(0)));
        row.add(intervals.get(0).get(0));
        row.add(intervals.get(0).get(1));
        ar.add(row);
        
        for(int i = 1; i < intervals.size(); i++) {
            int start = ar.get(ar.size() - 1).get(0);
            int end = ar.get(ar.size() - 1).get(1);
            int nextstart = intervals.get(i).get(0);
            int nextend = intervals.get(i).get(1);
            
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
