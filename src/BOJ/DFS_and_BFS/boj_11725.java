//  https://www.acmicpc.net/problem/11725
// 순서 무관하게 두 점을 n-1개 입력받고
// 2번노드부터 각 노드의 부모 출력.
// 단, 1번노드는 root
import java.util.*;
class Node {
    int num;
    List<Node> children;

    public Node (int n) {
        this.num = n;
        this.children = new ArrayList<>();
    }

    public void addChild (Node node) {
        this.children.add(node);
    }
}

class Tree {
    Node root;
    public Tree (Node rootnode) {
        this.root = rootnode;
    }
    public void addNode (Node n1, Node n2) {
        if (this.contains(n1)) {
            n1.children.add(n2);
        } else if (this.contains(n2)) {
            n2.children.add(n1);
        }
    }
    public boolean contains(Node node) {
        if(node.num == root.num) {
            return true;
        }
        else {
            Queue<Node> q = new LinkedList<> ();
            if (!root.children.isEmpty()) {
                for (Node n : root.children) {
                    if (n.num == node.num) return true;
                    else {
                        q.add(n);
                    }
                }
                    
            }
            while(!q.isEmpty()) {
                Node tmp = q.poll();
                for (Node n : root.children) {
                    if (n.num == node.num) return true;
                    else {
                        q.add(n);
                    }
                }
            }
            return false;
        }
    }
}
class Edge {
    int s; // smaller
    int l; // larger

    public Edge(int n1, int n2) {
        if (n1 < n2) {
            this.s = n1;
            this.l = n2;
        } else {
            this.s = n2;
            this.l = n1;
        }
    }
}
public class boj_11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        // arrayList edge 생성 후, node1 기준으로 정렬 한 다음
        // tree에 node 추가
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n-1; i ++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            edges.add(new Edge(n1, n2));
        }
        
        Comparator<Edge> c = new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.s - e2.s != 0 ? e1.s - e2.s : e1.l - e2.l;
            }
        };

        Collections.sort(edges, c);
        Tree tree = new Tree(new Node(1));
        for(Edge e : edges) {
            tree.addNode(new Node(e.s), new Node(e.l));
        }

        

    }
}
