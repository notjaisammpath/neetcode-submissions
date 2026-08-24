class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        set.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
            set.clear();
        }
        set.clear();
        for (int c = 0; c < 3; c++) {
            for (int d = 0; d < 3; d++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[3 * c + i][3 * d + j] != '.') {
                            if (set.contains(board[3 * c + i][3 * d + j])) {
                                return false;
                            }
                            set.add(board[3 * c + i][3 * d + j]);
                        }
                    }
                }

                set.clear();
            }
        }

        return true;
    }
}
