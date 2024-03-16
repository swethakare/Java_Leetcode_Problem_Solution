class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = matrix.length-1;
        int top = 0;
        int bottom = matrix[0].length-1;
        int ele = 1;
        while(ele <= n*n && left <= right && top <= bottom){
            for(int col = left; col<= right; col++){
                matrix[top][col] = ele;
                ele++;
            }
            top++;
            for(int row = top; row <= bottom; row++){
                matrix[row][right] = ele;
                ele++;
            }
            right--;
            if(top<=bottom){
            for(int col = right; col>= left; col--){
                matrix[bottom][col] = ele;
                ele++;
            }
            bottom--;
            }
            if(left <= right){
                
            for(int row = bottom; row >= top; row--){
                matrix[row][left] = ele;
                ele++;
            }
            left++;
            }
            
        }
        return matrix;
        
    }
}