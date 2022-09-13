// https://www.acmicpc.net/problem/1074
// 풀이참고: https://ilmiodiario.tistory.com/140

import java.util.*;
public class boj_1074 {
    public static int count = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int size = (int)Math.pow(2, n);

        // 배열을 사분면으로 나누고, 해당 위치가 몇사분면인지
        find(size, r, c);

        System.out.println(count);
        
    }
    private static final void find(int size, int r, int c) {
        if(size == 1) return;
        int newSize = size/2;
        if (r < size/2 && c < size/2){
            find(newSize, r, c);
        } else if (r < size/2 && c >= size/2) {
            count += (newSize * newSize);
            c -= newSize;
            find(newSize, r, c);
        } else if (r >= size/2 && c < size/2) {
            count += (newSize * newSize) * 2;
            r -= newSize;
            find(newSize, r, c);
        } else {
            count += (newSize * newSize) * 3;
            c -= newSize;
            r -= newSize;
            find(newSize, r, c);
        }
    }
}
