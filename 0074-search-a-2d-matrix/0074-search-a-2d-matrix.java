class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(col>=0 && row<matrix.length){
        if(target==matrix[row][col]){
            return true;
        }else if(target<matrix[row][col]){
            col--;// if
        }else if(target>matrix[row][col]){
            row++;// if target is greater the larger eles will be present on the next position.
        }
        }
        return false;
        }
}