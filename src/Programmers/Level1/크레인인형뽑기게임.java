// 메모리 사용 초과.. 배열 이용해서 생짜로 구현해보자!
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Stack<Integer>> dolls = new ArrayList<>();
        int n = board.length;
        for(int j = 0; j < n; j++){
            dolls.add(new Stack<Integer>());
            for (int i = n-1; j >= 0; j-- ) {
                dolls.get(j).push(board[i][j]);
            }
        }
        // System.out.println(dolls.size());
        
        Stack<Integer> basket = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            int idx = moves[i]-1;
            Stack<Integer> tmp = dolls.get(idx);
            if (!tmp.isEmpty()) {
                int doll = tmp.pop();
                if (!basket.isEmpty()) {
                    int top = basket.peek();
                    if (doll == top) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(doll);
                    }
                } else {
                    basket.push(doll);
                }
            }
        }
        
        return answer;
    }
}