/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static int v, e;
	public static int [] parent = new int[100001];
	
	// 특정원소 x가 속한 집합 찾기
	public static int findParent(int x){
		if(x == parent[x]) return x;
		else return parent[x] = findParent(parent[x]);
	}
	
	// union 연산
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		
		// 부모를 자기 자신으로 초기화
		for (int i = 1; i <= v; i ++) {
			parent[i] = i;
		}
		
		// 정보 입력받기
		for (int i = 0; i < e; i ++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			unionParent(a, b);
		}
		
		System.out.print("각 원소가 속한 집합: ");
		for (int i = 1; i <= v; i ++) {
			System.out.print(findParent(i) + " ");
		}
		
		System.out.print("\n각 원소의 부모: ");
		for (int i = 1; i <= v; i ++) {
			System.out.print(parent[i] + " ");
		}
	}
}