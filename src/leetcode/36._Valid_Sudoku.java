class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 가로, 세로, 작은 네모 총 27가지의 경우의 수 존재
        // 각 경우의 수에서 중복 숫자가 나타난 경우 return false. else, return true.
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[j][i] != '.' && set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
            set.clear();
        }
        
        // 1. 
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();
        
        // 2. 
        for (int i = 0; i < 3; i ++) {
            for (int j = 3; j < 6; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();

        // 3. 
        for (int i = 0; i < 3; i ++) {
            for (int j = 6; j < 9; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();

        // 4. 
        for (int i = 3; i < 6; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();

        // 5. 
        for (int i = 3; i < 6; i ++) {
            for (int j = 3; j < 6; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();

        // 6.
        for (int i = 3; i < 6; i ++) {
            for (int j = 6; j < 9; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();

        // 7.
        for (int i = 6; i < 9; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();

        // 8.
        for (int i = 6; i < 9; i ++) {
            for (int j = 3; j < 6; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();

        // 9.
        for (int i = 6; i < 9; i ++) {
            for (int j = 6; j < 9; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        set.clear();

        return true;
    }
}
