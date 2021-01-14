package Basics;

import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

//문제 https://www.acmicpc.net/problem/10825
public class boj_10825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        for (int i= 0; i < n; i++) {
            students.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        //국영수 순으로 점수 내림차, 이름 오름차
        /*Collections.sort(students, new Comparator<>() {
            @Override
            public int compare (Student s1, Student s2) {
                if (s1.kor < s2.kor){
                    return s1.kor-s2.kor;
                }
                else return s1.eng-s2.eng;
            }
        })*/

    }

    static class Student {
        int kor;
        int eng;
        int math;
        String name;

        public Student (String n, int k, int e, int m) {
            name = n;
            kor = k;
            eng = e;
            math = m;
        }
    }
}
