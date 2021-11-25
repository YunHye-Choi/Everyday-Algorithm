// 아 이건 DFS로 풀어야겠구나
class Solution {
    public static boolean[] checked;
    public static int graph[][];
    public void inSameNw(int [] ) {
        
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new int[computers[0].length][computers[0].length];
        
        for (int i = 0; i < computers[0].length; i++) {
            
        }
        
        // 로직이라도 생각해보자
        // [2] 1이 나오는 순간 해당 열 숫자를 가진 행으로 이동하여 for문을 돌며 다른 접점이 있는지 검사
        // [2-1] 이동하기 전, 체크했다는 표시 하는 boolean array에 true로 바꾸기~
        // [3] 체크 boolean이 false인 다른 접점이 없으면 break후 answer에 ++
        // [4] 다른 접점이 있으면 [2]로 이동하여 반복
        
        // 생성 시 기본 false로 초기화
        
        for (int i = 0 ; i < computers[0].length; i ++) {
            boolean thereIsOne = false;
            for (int j = 0; j < computers[0].length; j ++) {
                if (computers[i][j] == 1) {
                    thereIsOne = true;
                    
                    // 메서드를 만들어서 check 훑도록 하자
                }
                
            }
            // [1] 우선 한 행이 통째로 0인 경우는 answer에 ++됨
            if (!thereIsOne) answer++;
        }
        
        return answer;
    }
}