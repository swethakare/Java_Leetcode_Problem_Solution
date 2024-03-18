import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(pnt -> pnt[0]));
        int cnt = 0;
        int i = 0;
        while (i < points.length) {
            int end = points[i][1];
            int j = i + 1;
            while (j < points.length && points[j][0] <= end) {
                end = Math.min(end, points[j][1]);
                j++;
            }
            cnt++;
            i = j;
        }
        return cnt;
    }
}
