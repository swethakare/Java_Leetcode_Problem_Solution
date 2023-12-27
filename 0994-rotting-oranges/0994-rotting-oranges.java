class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<Coordinate> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        // Find the rotten oranges and enqueue them
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Coordinate(i, j));
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int min = 0;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; // Left, Up, Right, Down

        while (!q.isEmpty() && count > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Coordinate temp = q.poll();
                for (int[] dir : dirs) {
                    int newRow = temp.row + dir[0];
                    int newCol = temp.col + dir[1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Rotten the fresh orange
                        count--; // Decrease the count of fresh oranges
                        q.add(new Coordinate(newRow, newCol)); // Add the new rotten orange to the queue
                    }
                }
            }
            min++;
        }

        return count == 0 ? min : -1; // Return minutes or -1 if there are still fresh oranges
    }
}
