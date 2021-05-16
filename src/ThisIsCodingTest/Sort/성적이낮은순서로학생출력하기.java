// 해시 맵을 value기준으로 정렬하는 연습
// new Comparator() { 
//    public int compare (Entry e1, Entry e2) {
//      return e1.value - e2.value; //오름차순!
//    }
// }
// 이 문제에서 해시맵을 쓰면 동명이인을 처리할 수 없다 (이름이 key값이라서)
// 차라리 ArrayList<ArrayList<String>> 이차원 배열을 선언해서
// 이름과 점수를 모두 String으로 저장하고 비교시에만 Integer.parseInt()를 사용하자!

import java.util.*;
public class 성적이낮은순서로학생출력하기 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner (System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> arr = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            String name = sc.next();
            Integer score = sc.nextInt();
            arr.put(name, score);
        }
        ArrayList<Map.Entry<String, Integer>> students = new ArrayList<>(arr.entrySet());
        Collections.sort(arr, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {
                return s1.getValue.compareTo(s2.getValue());
            }
        });
        for (Map.Entry<String, Integer> stu : students) {
            System.out.print(stu.getKey() + " ");
        }
    }
}