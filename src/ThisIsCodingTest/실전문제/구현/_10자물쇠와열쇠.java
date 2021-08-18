class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int m = key[0].length;
        int n  = lock[0].length;
        int i_min=20, i_max=0, j_min=20, j_max=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] == 0) {
                    i_min = i < i_min ? i : i_min;
                    j_min = i < j_min ? i : j_min;
                    i_max = i > i_max ? i : i_max;
                    j_max = j > j_max ? j : j_max;
                }
            }
        }
        int row = i_max - i_min + 1;
        int col = j_max - j_min + 1;
        
        int part[][] = new int [row][col];
        
        int r = 0, c = 0;
        for (int i = i_min; i < i_max+1; i++) {
            for (int j = j_min; j < j_max+1; j++) {
                c = 0;
                part[r][c] = lock[i][j];
                c++;
            }
            r++;
        }
        
        // 회전 전에 한번 비교, 총 4번
        for(int case = 0; case < 4; case ++) {
            answer = true;
            // part 패턴중 하나라도 같으면, false
            r = 0, c = 0;
            for (int i = 0; i < m-row; i ++) {
                for (int j = 0; j < m-col; j ++) {
                    c = 0;
                    if (part[r][c] == key[i][j]) answer = false;
                    c++;
                }
                r++;
                if (answer) break;
            }
            if (answer) {
                break;
            } else {
                // 90도 회전하여 temp_key에 저장
                int temp_key = new int [m][m];
                int k = 0;
                for (int i = m-1; i >= 0; i --) {
                    for (int j = 0; j < m; j ++) {
                         temp_key[j][i] = key[k][j];
                    }
                    k++;
                }
                
                // key에 90도 돌아간 temp_key값 복사
                for (int i = 0; i < m; i ++) {
                    for (int j = 0; j < m ; j ++) {
                        key[i][j] = temp_key[i][j];
                    }
                }
            }
        }
        
        return answer;
    }
}