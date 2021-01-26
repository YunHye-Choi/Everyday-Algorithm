package Basics;

import java.util.Arrays;

public class boj_11652 {
    public static void main(String[] args) {
        int [] arr = new int [10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 2*i;
        }
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }

}
