/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public class Body {
		public int row;
		public int col;
		public Body (int r, int c) {
			row = r;
			col = c;
		}
	}
	public class Snake  {
		public ArrayList<Body> bodies;
		public Snake () {
			bodies = new ArrayList<Body>();
		}
	}
	
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
		Snake snake = new Snake();
		Snake past_snake = new Snake();
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
		
		// 1상 2하 3좌 4우
		int direction =  4;
		snake[1][1] = 1;
		int head_r=1, hear_c=1;
		
		snake.bodies.add(new Body(1, 1));
		
		// 게임이 끝나는 조건
		// 1. 머리와 몸이 닿는다 (다음 가야할 곳이 snake값이 1인 칸이다)
		// 2. 머리가 벽에 닿는다 (다음 인덱스가 배열 범위 벗어남)
		int time;
		for (time = 1; time < 10000; time ++) {
			
			if (time == 1)
				Body head = snake.bodies.get(0);
			else
				Body head = past_snake.bodies.get(0);
			
			if (direction == 4) {
				head.col++;
			} else if (direction == 3) {
				head.col--; // 좌
			} else if (direction == 1) {
				head.row --; // 상
			} else if (direction == 2) {
				head.row ++; // 하
			}
			
			if(head.row > n || head.col > n || head.row < 0 || head.col < 0 )
				break;
				
			snake.bodies.remove(0);
			snake.bodies.add(0, head);
			// 사과가 있는 경우	>> 사과를 없앤다
			if (apple[head.row][head.col] == 1) {
				apple[head.row][head.col] = 0;
			}
			// 사과가 없는 경우 >> 몸길이를 줄인다
			else {
				snake.bodies.remove(snake.bodies.size()-1);
			}
			
			
			
		}
		
		System.out.println(time);
	}
}