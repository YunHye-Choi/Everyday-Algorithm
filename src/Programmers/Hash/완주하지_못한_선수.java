// 문제: https://programmers.co.kr/learn/courses/30/lessons/42576?language=java

// 나의 풀이 (Hash 안씀)
// 접근법: 정렬 후 다른 부분의 index값 반환하기
/*
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int i = 0;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (String p: participant) {
            if (!p.equals(completion[i])) break;
            i++;
            if (i == completion.length) break;
        }
        answer = participant[i];
        return answer;
    }
}*/

// 프로그래머스 다른 사람의 풀이 
// https://programmers.co.kr/learn/courses/30/lessons/42576/solution_groups?language=java&type=all
// 접근법: 이름(String)을 key, 해당 이름을 가진 사람 수(Integer)를 value로 하는 해시에서
//         completion을 가지는 
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = ""

        // java 에서 HashMap 클래스 사용하기 key:String(이름), value: integer(명수)

        // put: HashMap에 key, value 넣기
        // getOrDefault: 찾는 key가 존재한다면 찾는 key의 값을 반환, 없다면 기본 값을 반환
        // get: key가 매개변수인 hash의 value 얻기
        // keySet: 저장된 key값 순서대로 set

        HashMap<String, Integer> hm = new HashMap<>();

        // hm의 value 중 중복되는(이미 저장된) 값이 있으면 1더한 값, 아니면 1을 value로 넣기 (사람수 세기)
        for (String player:participant) hm.put(player, hm.getOrDefault(player,0)+1);
        // hm의 value에 다시 -1을 해놓기
        for (String player:completion) hm.put(player, hm.get(player) - 1);

        // 위 코드 결과 동명이인의 경우도 -1 을 중복해서 하기 때문에
        // completion에 포함된 사람은 모두 value를 0으로 갖고, 아닌 사람 1명만 1을 가지게 된다.
        
        for (String key : hm.keySet()) {
            if(hm.get(key) != 0) {// if(hm.get(key) == 1) 로도 가능함!
                answer = key;
            }
        }
        return answer;
    }
}