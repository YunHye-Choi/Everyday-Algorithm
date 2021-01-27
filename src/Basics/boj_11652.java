package Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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
            System.out.println(i);
            if(arr[i] == arr[i-1]) {
                pairs.add(j, new Pair(arr[i], pairs.get(j).cnt+1));
                System.out.println(new Pair(arr[i], pairs.get(j).cnt));
            } else {
                j++;
                pairs.add(j, new Pair(arr[i], 1));
                System.out.println(new Pair(arr[i], pairs.get(j).cnt));
            }
        }
        System.out.println("size: " + pairs.size());
        long max = 0;
        for (Pair pair:pairs) {
            System.out.println(pair);
            max = pair.cnt > max ? pair.num : max;
        }
        System.out.println(max);
    }
    static class Pair {
        public long num;
        public int cnt;

        public Pair(long n, int c) {
            num = n;
            cnt = c;
        }
        @Override
        public String toString(){
            return num + ": " + cnt +"개";
        }
    }
}
