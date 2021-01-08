package Basics;

import java.util.Scanner;

public class boj_2751 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();;
        int arr[] = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int num:arr){
            System.out.println(num);
        }
    }
}
