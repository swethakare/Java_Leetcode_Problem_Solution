import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        ArrayList<Integer> ar = new ArrayList<Integer>();
        
        while (top <= bottom && left <= right) {
             for(int col = left; col <= right; col++){
                 ar.add(matrix[top][col]);
             }
            top++;
            for(int row = top; row <= bottom; row++){
                ar.add(matrix[row][right]);
            }
            right--;
            if( top <= bottom){
                for(int col = right; col >= left; col--){
                ar.add(matrix[bottom][col]);
                }
                bottom--;   
            }
            if(left <= right){
              for(int row = bottom; row >= top; row--){
                  ar.add(matrix[row][left]);
              }
              left++;  
            }
        }
        return ar;
    }
}
