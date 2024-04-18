import java.util.*;

class item {
    int x, y;
    item(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] nimage = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                nimage[i][j] = image[i][j];
            }
        }
        
        int inicolor = image[sr][sc];
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, -1, 0, +1};
        Queue<item> q = new LinkedList<>();
        q.add(new item(sr, sc));
        nimage[sr][sc] = color;
    
        while (!q.isEmpty()) {
            item it = q.poll();
            int row = it.x;
            int col = it.y;
            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length) {
                    if (color != nimage[nrow][ncol] && nimage[nrow][ncol] == inicolor) {
                        q.add(new item(nrow, ncol));
                        nimage[nrow][ncol] = color;
                    }
                }
            }
        }
        return nimage;
    }
}
