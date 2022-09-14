class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        int yRow = 1;
        int yCol = yellow;
        
        while(yRow <= yCol){
            if (yRow * 2 + yCol * 2 + 4 == brown){
                break;
            } else {
                while (true) {
                    yRow++;
                    yCol = yellow/yRow;
                    if (yellow % yRow == 0) break;
                }
                
            }
        }
        
        answer[0] = yCol + 2;
        answer[1] = yRow + 2;
        
        return answer;
    }
}