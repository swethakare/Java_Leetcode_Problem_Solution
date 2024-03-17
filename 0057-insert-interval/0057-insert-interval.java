import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ar = new ArrayList<>();
        int i = 0 ;
        while( i<intervals.length && intervals[i][1] < newInterval[0]){
            ar.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ar.add(newInterval);
        for(int j = i; j< intervals.length; j++){
            ar.add(intervals[j]);
        }
        int[][] res = new int[ar.size()][2];
        for(int j = 0 ; j< res.length; j++){
            res[j] = ar.get(j);
    
        }
        return res;
    } 

}
