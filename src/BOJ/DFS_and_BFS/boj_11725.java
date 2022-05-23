//  https://www.acmicpc.net/problem/11725
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
public class boj_11725 {
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n-1; i ++) {
        sc.nextInt();
        // 순서 무관하게 두 점을 n-1개 입력받고
        // 2번노드부터 각 노드의 부모 출력.
        // 단, 1번노드는 root
    }
}
