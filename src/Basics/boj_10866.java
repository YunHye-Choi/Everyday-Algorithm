package Basics;

// 문제: https://www.acmicpc.net/problem/10866

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj_10866 {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] commands = new String[n];
        for (int i = 0; i< n; i ++) {
            commands[i] = br.readLine();
        }
        Deque deque = new Deque();
        //

    }
    static class Deque {
        ArrayList<Integer> deques = new ArrayList<>();
        void push_front (int x) {

        }
        void push_back (int x) {

        }
        void pop_front () {

        }
        void pop_back () {

        }

        void size () {

        }
        void empty () {

        }
        void front () {

        }
        void back() {

        }
    }
}
