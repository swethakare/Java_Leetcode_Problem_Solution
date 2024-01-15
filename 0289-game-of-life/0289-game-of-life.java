class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lv = livecell(board, i, j, board.length, board[0].length);
                if (board[i][j] == 1 && lv < 2) {
                    board[i][j] = 3; // newlydead
                }
                // if (board[i][j] == 1 && (lv == 2 || lv == 3)) {
                //     board[i][j] = 2; // newlyalive // no need to change the already alive cell ingone the cell updation.
                // }
                if (board[i][j] == 1 && lv > 3) {
                    board[i][j] = 3; // newlydead
                }
                if (board[i][j] == 0 && lv == 3) {
                    board[i][j] = 2; // newlylive
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int livecell(int[][] board, int i, int j, int rowlen, int collen) {
        int live = 0;
        // upper
        if (i > 0) {
            if (board[i - 1][j] == 1 || board[i - 1][j] == 3) {
                live++;
            }
        }
        // lower
        if (i < rowlen - 1) {
            if (board[i + 1][j] == 1 || board[i + 1][j] == 3) {
                live++;
            }
        }
        // left
        if (j > 0) {
            if (board[i][j - 1] == 1 || board[i][j - 1] == 3) {
                live++;
            }
        }
        // right
        if (j < collen - 1) {
            if (board[i][j + 1] == 1 || board[i][j + 1] == 3) {
                live++;
            }
        }
        // left upper diag
        if (i > 0 && j > 0) {
            if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 3) {
                live++;
            }
        }
        // right upper diag
        if (i > 0 && j < collen - 1) {
            if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 3) {
                live++;
            }
        }
        // left lower diag
        if (i < rowlen - 1 && j > 0) {
            if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 3) {
                live++;
            }
        }
        // right lower diag
        if (i < rowlen - 1 && j < collen - 1) {
            if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 3) {
                live++;
            }
        }
        return live;
    }
}
