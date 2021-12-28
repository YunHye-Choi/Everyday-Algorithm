

import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// 문제 https://www.acmicpc.net/problem/10825
// 내림차수 정렬은 compare메서드에서 빼기 순서 반대로!

public class boj_10825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        for (int i= 0; i < n; i++) {
            students.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        // 국 내림차, 국 같으면 수 오름차, 수도 같으면 영 내림차, 영도 같으면 이름 오름차
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare (Student s1, Student s2) {
                if (s1.kor == s2.kor) {
                    if (s1.eng == s2.eng) {
                        if(s1.math == s2.math){
                            return s1.name.compareTo(s2.name);
                        } else return s2.math - s1.math;
                    } else return s1.eng - s2.eng;
                } else return s2.kor - s1.kor;
            }
        });

        for (Student s : students) {
            System.out.println(s.name);
        }

    }

    static class Student {
        int kor;
        int eng;
        int math;
        String name;

        // 이름, 국, 영, 수 점수 순서로 입력받아 생성
        public Student(String n, int k, int e, int m) {
            name = n;
            kor = k;
            eng = e;
            math = m;
        }
    }
}
