// 아.. for 문 잘못 돌려서 메모리 초과인 거였다..^^
// Stack 활용 굳..^^
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Stack<Integer>> dolls = new ArrayList<>();
        int n = board.length;
        for(int j = 0; j < n; j++){
            dolls.add(new Stack<Integer>());
            for (int i = n-1; i >= 0; i-- ) {
                if(board[i][j] != 0) {
                    dolls.get(j).push(board[i][j]);
                }
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