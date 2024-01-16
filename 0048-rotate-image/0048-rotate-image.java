class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        matrix = reverseRow(matrix);

    }
    public int[][] reverseRow(int[][] matrix){
        int startrow = 0;
        // int endrow = matrix.length-1;
        while(startrow < matrix.length){
            int startcol = 0;
            int endcol = matrix[0].length-1;
            while(startcol < endcol){
                int temp = matrix[startrow][startcol];
                matrix[startrow][startcol] = matrix[startrow][endcol];
                matrix[startrow][endcol] = temp;
                startcol++;
                endcol--;
            }
            startrow++;
            
            
        }
        return matrix; 
    }
   
}
  

