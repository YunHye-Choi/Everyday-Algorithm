// 해시 맵을 value기준으로 정렬하는 연습
// new Comparator() { 
//    public int compare (Entry e1, Entry e2) {
//      return e1.value - e2.value; //오름차순!
//    }
// }

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