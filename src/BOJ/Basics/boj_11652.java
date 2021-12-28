

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 문제: https://acmicpc.net/problem/11652

public class boj_11652 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long [] arr = new long [n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(arr[0], 1));
        int j = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]) {
                int cnt = pairs.remove(j).cnt+1;
                pairs.add(j, new Pair(arr[i], cnt));
            } else {
                j++;
                pairs.add(j, new Pair(arr[i], 1));
            }
        }
        long maxnum = 0; int maxcnt = 0;
        for (Pair pair:pairs) {
            if (pair.cnt > maxcnt) {
                maxnum = pair.num;
                maxcnt = pair.cnt;
            }
        }
        System.out.println(maxnum);
    }
    static class Pair {
        public long num;
        public int cnt;

        public Pair(long n, int c) {
            num = n;
            cnt = c;
        }
    }
}
