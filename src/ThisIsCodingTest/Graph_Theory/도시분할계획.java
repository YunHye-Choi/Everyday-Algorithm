import java.util.*;
import java.lang.*;

class Edge implements Comparable <Edge> {
	private int cost;
	private int nodeA;
	private int nodeB;
	public Edge(int a, int b, int c) {
		nodeA = a;
		nodeB = b;
		cost = c;
	}
	public int getCost(){
		return cost;
	}
	public int getNodeA(){
		return nodeA;
	}
	public int getNodeB(){
		return nodeB;
	}
	
	@Override
	public int compareTo(Edge other) {
		if (this.cost < other.cost) {
			return -1;
		} else return 1;
	}
}

public class Main{
	public static int v, e;
	public static int [] parent = new int[100001];
	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int result = 0;
	
	public static int findParent(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static boolean isThereCycle(int a, int b) {
		if(findParent(a) == findParent(b)) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < e; i ++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new Edge(a, b, cost));
		}
		
		Collections.sort(edges);
		int maxCost = -1;
		for (Edge e : edges) {
			int a = e.getNodeA();
			int b = e.getNodeB();
			int c = e.getCost();
			if (!isThereCycle(a, b)) {
				unionParent(a, b);
				result += c;
				maxCost = Math.max(e.getCost(), maxCost);
			}
		}
		
		result -= maxCost;
		
		System.out.println(result);
		
	}
}