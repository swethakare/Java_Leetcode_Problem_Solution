class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidCol(board, i) || !isValidGrid(board, i))
                return false;
        }
        return true;
    }
    boolean isValidRow(char[][] board, int col){
        boolean used[] = new boolean[9];
        for(int i = 0 ; i < 9; i++){
            char digit = board[i][col];
            if(digit != '.'){
                if(used[digit - '1']){
                    return false;
                }
                used[digit - '1'] = true;
            }
        }
        return true;
    }
    boolean isValidCol(char[][] board, int row){
        boolean used[] = new boolean[9];
        for(int i = 0; i < 9; i++){
            char digit = board[row][i];
            if(digit != '.'){
                if(used[digit - '1']){
                    return false;
                }
                used[digit - '1'] = true;
            }
        }
        return true;
    }
    boolean isValidGrid(char[][] board, int i){
        boolean used[] = new boolean[9];
        int rowstart = (i / 3)*3;
        int colstart = (i % 3)*3;
        for(int row = rowstart; row < rowstart+3; row++){
                for(int col = colstart; col <colstart+3; col++){
                    char digit = board[row][col];
                    if(digit !='.'){
                        if(used[digit - '1']){
                            return false;
                        }
                        used[digit -'1'] = true;
                    }
                }
            }
        return true;
    }
}
    
    
