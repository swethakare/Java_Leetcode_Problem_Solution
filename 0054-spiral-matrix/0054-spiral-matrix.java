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
            // Traverse top row
            for (int col = left; col <= right; col++) {
                ar.add(matrix[top][col]);  
            }
            top++;
            
            // Traverse right column
            for (int row = top; row <= bottom; row++) {
                ar.add(matrix[row][right]);
            }
            right--;
            
            // Traverse bottom row
            if (top <= bottom) { // Ensure top and bottom haven't crossed
                for (int col = right; col >= left; col--) {
                    ar.add(matrix[bottom][col]);
                }
                bottom--;
            }
            
            // Traverse left column
            if (left <= right) { // Ensure left and right haven't crossed
                for (int row = bottom; row >= top; row--) {
                    ar.add(matrix[row][left]);
                }
                left++;
            }
        }
        
        return ar;
    }
}
