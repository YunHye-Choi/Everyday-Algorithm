// ����: https://programmers.co.kr/learn/courses/30/lessons/42576?language=java

// ���� Ǯ�� (Hash �Ⱦ�)
// ���ٹ�: ���� �� �ٸ� �κ��� index�� ��ȯ�ϱ�
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

// ���α׷��ӽ� �ٸ� ����� Ǯ�� 
// https://programmers.co.kr/learn/courses/30/lessons/42576/solution_groups?language=java&type=all
// ���ٹ�: �̸�(String)�� key, �ش� �̸��� ���� ��� ��(Integer)�� value�� �ϴ� �ؽÿ���
//         completion�� ������ 
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = ""

        // java ���� HashMap Ŭ���� ����ϱ� key:String(�̸�), value: integer(���)

        // put: HashMap�� key, value �ֱ�
        // getOrDefault: ã�� key�� �����Ѵٸ� ã�� key�� ���� ��ȯ, ���ٸ� �⺻ ���� ��ȯ
        // get: key�� �Ű������� hash�� value ���
        // keySet: ����� key�� ������� set

        HashMap<String, Integer> hm = new HashMap<>();

        // hm�� value �� �ߺ��Ǵ�(�̹� �����) ���� ������ 1���� ��, �ƴϸ� 1�� value�� �ֱ� (����� ����)
        for (String player:participant) hm.put(player, hm.getOrDefault(player,0)+1);
        // hm�� value�� �ٽ� -1�� �س���
        for (String player:completion) hm.put(player, hm.get(player) - 1);

        // �� �ڵ� ��� ���������� ��쵵 -1 �� �ߺ��ؼ� �ϱ� ������
        // completion�� ���Ե� ����� ��� value�� 0���� ����, �ƴ� ��� 1�� 1�� ������ �ȴ�.
        
        for (String key : hm.keySet()) {
            if(hm.get(key) != 0) {// if(hm.get(key) == 1) �ε� ������!
                answer = key;
            }
        }
        return answer;
    }
}