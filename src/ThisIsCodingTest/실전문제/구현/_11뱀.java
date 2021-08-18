/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n, k, turn;
		
		Scanner sc = new Scanner (System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		// 0으로 초기화된 nXn 이차원 배열
		// 0은 일반 길, 1은 사과 있는 길
		int [][] apple = new int [n+1][n+1];
		
		// 뱀의 상태를 나타내는 배열, 초기 모두 0, 뱀의 몸통은 1
		// 이후[1][1] 칸이 1로 초기화됨
		int [][] snake = new int [n+1][n+1];
		for (int i = 0; i < k; i++) {
			int row, col;
			row = sc.nextInt();
			col = sc.nextInt();
			apple [row][col] = 1;
		}
		
		turn = sc.nextInt();
		
		int [] turn_int = new int [turn];
		char [] turn_char = new char [turn];
		
		for (int i=0; i < turn; i++) {
			turn_int[i] = sc.nextInt();
			turn_char[i] = sc.nextChar();
		}
		
		// 초기 값 세팅
		int turn_idx = 0;
		char direction =  'D';
		snake[1][1] = 1;
		
		// 게임이 끝나는 조건
		// 1. 머리와 몸이 닿는다 (다음 가야할 곳이 snake값이 1인 칸이다)
		// 2. 머리가 벽에 닿는다 (다음 인덱스가 배열 범위 벗어남)
		for (int time = 0; time < 10000; time ++) {
			
		}
	}
}