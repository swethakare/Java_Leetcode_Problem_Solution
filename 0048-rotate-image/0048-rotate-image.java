class Solution {
    public void rotate(int[][] matrix) {
        // Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        int k = matrix[0].length - 1;
        int j = 0;
        while (j < k) {
            for (int i = 0; i < matrix.length; i++) {
                int temp1 = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp1;
            }
            j++;
            k--;
        }
    }
}
