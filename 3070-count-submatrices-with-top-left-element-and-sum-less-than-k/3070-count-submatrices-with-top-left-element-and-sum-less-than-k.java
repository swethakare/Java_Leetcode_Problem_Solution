class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int currow = 0;
        int curcol = 0;
        int sum = 0;
        int count = 0;
            for(int j  = 0; j<grid[0].length; j++){
                sum = sum + grid[0][j];
                grid[0][j] = sum;
                if(sum <= k){
                    count++;
                }
            }
            sum = 0;
            for(int j  = 0; j<grid.length; j++){
                sum = sum + grid[j][0];
                grid[j][0] = sum;
                if(sum <= k){
                    count++;
                }
            }
        
        for(int i = 1 ; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                grid[i][j] = grid[i][j]+grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
                if(grid[i][j]<=k){
                    count++;
                }
                
            }
        }
        return grid[0][0] <= k ? count-1 : count;

    }
 
}

