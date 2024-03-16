class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidGrid(board, i))
                return false;
        }
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        boolean[] used = new boolean[9];
        for (int col = 0; col < 9; col++) {
            char digit = board[row][col];
            if (digit != '.') {
                if (used[digit - '1']) {
                    return false; // Found a duplicate
                }
                used[digit - '1'] = true;
            }
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int col) {
        boolean[] used = new boolean[9];
        for (int row = 0; row < 9; row++) {
            char digit = board[row][col];
            if (digit != '.') {
                if (used[digit - '1']) {
                    return false; // Found a duplicate
                }
                used[digit - '1'] = true;
            }
        }
        return true;
    }
    
    private boolean isValidGrid(char[][] board, int grid) {
        boolean[] used = new boolean[9];
        int rowStart = (grid / 3) * 3;
        int colStart = (grid % 3) * 3;
        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                char digit = board[row][col];
                if (digit != '.') {
                    if (used[digit - '1']) {
                        return false; // Found a duplicate
                    }
                    used[digit - '1'] = true;
                }
            }
        }
        return true;
    }
}
