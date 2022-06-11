class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zeroCnt = 0;
        int wow = 0;
        for(int l : lottos) {
            if (l == 0) {
                zeroCnt ++;
                continue;
            }
            for (int w : win_nums) {
                if (l == w) {
                    wow++;
                }
            }
        }
        answer = new int [2];
        
        answer[0] = 7 - (wow + zeroCnt);
        answer[1] = 7 - wow;
        for(int i = 0 ; i < 2; i++){
            if (answer[i] >= 7) answer[i] = 6;
        }
        return answer;
    }
}