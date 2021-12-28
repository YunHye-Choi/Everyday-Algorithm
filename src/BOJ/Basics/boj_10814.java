

import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// 문제 https://www.acmicpc.net/problem/10814
// 참고 https://offbyone.tistory.com/154

public class boj_10814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            members.add(new Member(scanner.nextInt(), scanner.nextLine()));
        }

        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return m1.age - m2.age;
            }
        });

        for (int i = 0; i<n;i++) {
            System.out.println(members.get(i).age+members.get(i).name);
        }

    }
    static class Member {
        public int age;
        public String name;

        public Member(int a, String n) {
            age = a;
            name = n;
        }
    }
}
