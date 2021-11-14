// 풀이 참고: https://sas-study.tistory.com/215

import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 구글링해서 찾은 솔루션:
        // 각 종류의 이름 수 + 1 한것들을 모두 곱한 수 - 1
        // 이 풀이의 키포인트는 '한 종류가 없다는 것'을 하나의 경우로 포함시켰다는 것!
        
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            if (!hm.containsKey(clothes[i][1])) {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(clothes[i][0]);
                hm.put(clothes[i][1],tmp);
            } else {
                hm.get(clothes[i][1]).add(clothes[i][0]);
            }
        }
        
        for (Map.Entry<String,ArrayList<String>> ent : hm.entrySet()) {
            System.out.println(ent.getKey()+" "+ent.getValue());
            answer *= ent.getValue().size() + 1;
            
        }
        
        answer --;
        
        return answer;
    }
}