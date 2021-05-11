package BOJ;

import java.util.*;
import java.io.*;
// DFS 이용하여 다시 풀어보자......
// 아래 코드는 메모리 초과
public class boj_9466 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int numOfS = 0;
        // key: 학생번호 value:그 학생이 찍은 번호
        ArrayList<HashMap<Integer, Integer>> hms = new ArrayList<HashMap<Integer, Integer>>();
        for (int i = 0; i < n; i++) {
            numOfS = sc.nextInt();
            //ArrayList<Integer>();// index는 해당 학생번호, value는 그 학생이 찍은 학생의 번호
            HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
            for (int j = 0; j < numOfS; j++) {
                tmp.put(j+1,sc.nextInt());
            }
            hms.add(tmp);
        }
        for (HashMap<Integer, Integer> hm : hms) {
            int ans = hm.size(); // 일단 모든 학생이 안된다고 초기화 시켜둠
            for (int j = 1; j <= numOfS; j++) {
                if(!hm.containsValue(j)) {// 들어온 아이를 찍은 사람이 없다면
                    continue; //false반환
                }
                if (hm.get(j) == j){ // 첫 사람이 자신을 찍었다면?
                    // 내가 믿을 사람은 나 뿐!
                    ans --; // 나는 팀한다~
                    continue;
                }
                // 순환 하는지 아닌지 판단 갑니다~
                if (teamOrNot(j, j, hm)) ans--; // 순환하면 팀이니까 --
            }
            System.out.println("ans: " + ans);
        }
    }

    //해당 index를 가진 학생이 팀인지 아닌지 반환
    public static boolean teamOrNot(int init,int stu, HashMap<Integer,Integer> whole) {
        // (이미 init이 init을 찍거나 누구도 이 init을 찍지 않은 case는 거름)
        // 이 아이는 누구 찍었을까?
        System.out.println("init: " + init + " stu: " +  stu);
        if (stu!=init && whole.get(stu) == stu) { // init이 아닌 사람이 본인을 찍엇다면
            return false;
        }
        if (stu!=init && whole.get(stu) == init) // 찍은사람의..찍사의...찍사가 init을 찍었다면?
            return true;
        return teamOrNot(init, whole.get(stu), whole);
    }
}
