import java.util.*;

class Vertex {
	private int idx;
	private int cost;
	private ArrayList<Integer> inVertex;
	public Vertex(int i, int c){
		idx = i;
		cost = c;
		inVertex = new ArrayList<Integer>();
	}
	public getIdx() {
		return idx;
	}
	public getCost() {
		return Cost;
	}
	public getInVertex(){
		return inVertex;
	}
}
public class Main{
	public static int v;
	public static ArrayList<Vertex> vertexes = new ArrayList();
	public static int[] indegree = new int [100001];
	//public static int[] did = new int [100001];
	public static int[] ans = new int [100001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		
		vertexes.add(new Vertex(0, 0));
		
		for (int i = 1; i <= v; i++) {
			int c = sc.nextInt();
			vertexes.add(new Vertex(i, c));
			int num = sc.nextInt();
			while(num != -1) {
				vertexes.get(i).getInVertex().add(new Vertex());
			}
		}
		
		for (int i = 1; i <= vertexes.size(); i ++) {
			Vertex v = vertexes.get(i)
			ans[i] += v.getCost();
			while (v.getInVertex().size() != 0) {
				int minCost = 1000001;
				int minIdx = -1;
				for (int verIdx : v.getInvertex()){
					if (vertexes.get(verIdx).getCost() < minCost) {
						minCost = vertexes.get(verIdx).getCost();
						minIdx = verIdx;
					}
				}
				ans[i] += minCost;
				v = vertexes.get(minIdx);
			}
		}
		
		for (int i = 1; i <= v; i++) {
			System.out.println(ans[i]);
		}
	}
	
}