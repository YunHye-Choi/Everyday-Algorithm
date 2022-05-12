// https://www.acmicpc.net/problem/1991
// 풀이: https://codingjerk-diary.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%ED%92%80%EC%9D%B4%EB%B0%B1%EC%A4%80-1991-%ED%8A%B8%EB%A6%AC-%EC%88%9C%ED%9A%8C-JAVA
import java.util.*;
class Node {
    char val;
    Node left;
    Node right;

    public Node (char v) {
        this.val = v;
    }

    public String toString() {
        return val + "";
    }
}
public class boj_1991 {
    public static Node[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new Node[n];
        sc.nextLine();
        char a = 'A';
        for(int i = 0; i < n; i ++) {
            tree[i] = new Node(a++);
        }

        for(int i = 0; i < n ; i ++) {
            char[] arr = sc.nextLine().toCharArray();
            tree[arr[0]-65].left = arr[2] == '.'? null : tree[arr[2] - 65];
            tree[arr[0]-65].right = arr[4] == '.'? null : tree[arr[4] - 65];
        }

        System.out.println(preorder(tree[0]));
        System.out.println(inorder(tree[0]));
        System.out.println(postorder(tree[0]));
    }
    private static String preorder(Node n) {
        String retVal =  "";
        retVal += n.val;
        if(n.left != null) {
            retVal += preorder(n.left);
        }
        if(n.right != null) {
            retVal += preorder(n.right);
        }
        return retVal;
    }
    private static String inorder(Node n) {
        String retVal =  "";
        if(n.left != null) {
            retVal += inorder(n.left);
        }
        retVal += n.val;
        if(n.right != null) {
            retVal += inorder(n.right);
        }
        return retVal;
    }
    private static String postorder(Node n) {
        String retVal =  "";
        if(n.left != null) {
            retVal += postorder(n.left);
        }
        if(n.right != null) {
            retVal += postorder(n.right);
        }
        retVal += n.val;
        return retVal;
    }
}