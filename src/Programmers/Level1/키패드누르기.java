import java.util.*;
class Posi{
    int row;
    int col;
    public Posi(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        HashMap<String, Posi> map = new HashMap<>();
        String[] pad = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
        int i = 0;
        for (int row = 0; row < 4; row ++) {
            for (int col = 0; col < 3; col ++) {
                map.put(pad[i++], new Posi(row, col));
            }   
        }
        String lp = "*";
        String rp = "#";
        for(int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                answer += "L";
                lp = n +"";
            } else if (n == 3 || n == 6 || n == 9) {
                answer += "R";
                rp = n + "";
            } else {
                String tmp = n + "";
                int lDist = Math.abs(map.get(lp).row - map.get(tmp).row) + Math.abs(map.get(lp).col - map.get(tmp).col);
                int rDist = Math.abs(map.get(rp).row - map.get(tmp).row) + Math.abs(map.get(rp).col - map.get(tmp).col);
                if (lDist < rDist) {
                    lp = tmp;
                    answer += "L";
                } else if (lDist > rDist) {
                    rp = tmp;
                    answer += "R";
                } else {
                    if (hand.equals("left")) {
                        lp = tmp;
                        answer += "L";
                    } else {
                        rp = tmp;
                        answer += "R";
                    }
                }
            }
        }
        return answer;
    }
}