class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char [] arr = s.toCharArray();
        char [][] ans = new char[1000][1000];
        int idx = 0;
        int row = 0, col = 0;
        while (idx < arr.length) {
            for (row = 0; row < numRows; row ++) {
                if (idx == arr.length) break;
                ans[row][col] = arr[idx++];
            }
            col++;
            // 우상향 대각선
            if (numRows > 2) {
                for (row = numRows - 2; row >= 1; row --) {
                    if (idx == arr.length) break;
                    ans[row][col++] = arr[idx++];
                }
            }
        }
        String ansString = "";
        for (int r = 0; r < numRows; r ++){
            for (int c = 0; c <= col; c ++) {
                if (ans[r][c] != '\0') {
                    ansString += ans[r][c]+"";
                }
            }
        }
        return ansString;
    }
}