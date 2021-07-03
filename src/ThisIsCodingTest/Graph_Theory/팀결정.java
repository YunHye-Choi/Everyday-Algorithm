// sampleInput
/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int n, m; // n: 노드의 수, m : 연산의 수
	
	public static int parent[] = new int[100001];
	
	public static int findParent(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
    // 사이클이 발생하는 지 확인. 사이클이 발생하면 YES, 아니면 NO출력
    // 부모가 같으면 사이클이 발생한다고 봄 (방향성이 없는 그래프이기 때문에)
	public static void sameTeamOrNot (int a, int b) {
		if (findParent(a) == findParent(b)) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		String[] line = new String [m];
		for (int i = 0; i < m; i++) {
			line[i] = sc.nextLine();
		}
		
		for (int i = 1; i <= n; i ++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i ++) {
			String[] lineSp = line[i].split(" ");
			int command = Integer.parseInt(lineSp[0]);
			int a = Integer.parseInt(lineSp[1]);
			int b = Integer.parseInt(lineSp[2]);
			
			if (command == 0) { // union
				unionParent(a, b);
			}else { // check same team or not (1)
				sameTeamOrNot(a, b);
			}
		}
	}
}