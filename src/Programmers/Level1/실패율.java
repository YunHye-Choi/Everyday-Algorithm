import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 1부터 n까지 데이터 생성한다음
        // stages 순회하며 생성한 데이터에 ++해줌
        // 실패율 계산한 뒤 데이터에 삽입,
        // 실패율 계산 후 answer에 key값 담아서 return
        HashMap<Integer, Double> hm = new HashMap<>(); 
        for(int i = 1; i <= N; i ++) {
            hm.put(i, 0.0);
        }
        for (int s : stages) {
            hm.put(s, hm.get(s) + 1);
        }
        int players = stages.length;
        for(int i = 1; i <= N; i ++) {
            double tmp = hm.get(i);
            hm.put(i, hm.get(i)/players);
            players -= tmp;
            if (players == 0) break;
        }
        
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Double>> (){
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return (int)(o2.getValue() - o1.getValue());
            }
        });
        int idx = 0;
        for(Map.Entry<Integer, Double> entry : entryList){
	        answer[idx++] = entry.getKey();
        }
        return answer;
    }
}