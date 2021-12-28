

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 문제: https://acmicpc.net/problem/11004

public class boj_11004 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        String string = br.readLine();
        String[] s = string.split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int arr[] = new int[n];
        string = br.readLine();
        String[] s_ = string.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s_[i]);
        }
        Arrays.sort(arr);
        System.out.print(arr[k-1]);
    }
}
