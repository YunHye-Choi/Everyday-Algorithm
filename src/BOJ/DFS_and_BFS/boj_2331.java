// 간단한 문제였지만 틀렸다..
// 각 자리수를 처리하는 방법을 잘 몰랐던 것 같다. 계속 10으로 나눈 몫을 저장하며 0이 아닐때 까지 while문 돌기
// 풀이참고: https://steady-coding.tistory.com/32
// https://www.acmicpc.net/problem/2331
import java.util.*;
import java.lang.*;
public class boj_2331 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner (System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int a = sc.nextInt();
        int p = sc.nextInt();
        int num = a;
        int idx = 0;
        int ans = 0;
        arr.add(a);
        while (true) {
            num = arr.get(arr.size() - 1);
            int sum = 0;
            // 어떤 수의 각 자리에 대해 P제곱만큼하여 각 자리를 더한 값을 구함.
            while(num != 0) {
                sum += (int)Math.pow(num % 10, p);
                num /= 10;
            }
            if (arr.contains(sum)) {
                ans = arr.indexOf(sum);
                break;
            } else {
                arr.add(sum);
            }
        }
        System.out.println(ans);
    }
}
