class Solution {
    public String convert(String s, int numRows) {
        char [] arr = s.toCharArray();
        char [] ans = new char[1000][1000];
        int idx = 0;
        for (int col = 0; col < 1000; col += (numRows-1)) {
            for(int row = 0; row < numRows; row ++) {
                ans[row][col] = arr[idx++];
            }
            for (int col2 = 0; col2 < )
        }
        
    }
}