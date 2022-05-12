// https://www.acmicpc.net/problem/1991
// 풀이: https://codingjerk-diary.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%ED%92%80%EC%9D%B4%EB%B0%B1%EC%A4%80-1991-%ED%8A%B8%EB%A6%AC-%EC%88%9C%ED%9A%8C-JAVA
import java.util.*;
class Node {
    char val;
    Node left;
    Node right;

    public Node(char val) {
        this.val = val;
    }

    public String toString() {
        return val+"";
    }
}
public class boj_1991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] tree = new Node[n];
        char a = 'A';
        for (int i = 0; i < n ; i ++) {
            tree[i] = new Node(a ++);
        }
        sc.nextLine();
        
        for (int i = 0; i < n ; i ++ ) {
            char[] arr = sc.nextLine().toCharArray();
            tree[arr[0]-65].left = arr[2] == '.'? null : tree[arr[2] - 65];
            tree[arr[0]-65].right = arr[4] == '.'? null : tree[arr[4] - 65];
        }

        System.out.println(preorder(tree[0]));
        System.out.println(inorder(tree[0]));
        System.out.println(postorder(tree[0]));

    }
    private static String preorder(Node node) {
        String ans = "";
        ans += node.val;
        if (node.left != null) ans += preorder(node.left);
        if (node.right != null) ans += preorder(node.right);
        return ans;
    }
    private static String inorder(Node node) {
        String ans = "";
        if (node.left != null) ans += inorder(node.left);
        ans += node.val;
        if (node.right != null) ans += inorder(node.right);
        return ans;
    }
    private static String postorder(Node node) {
        String ans = "";
        if (node.left != null) ans += postorder(node.left);
        if (node.right != null) ans += postorder(node.right);
        ans += node.val;
        return ans;
    }
}