public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(pnt -> pnt[0]));
        int arrows = 1;
        int maxRange = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];
            if (start <= maxRange) {
                maxRange = Math.min(maxRange, end);
            } else {
                arrows++;
                maxRange = end;
            }
        }

        return arrows;
    }
}
