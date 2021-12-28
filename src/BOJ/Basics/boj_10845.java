

// 문제: https://www.acmicpc.net/problem/10845
// 자바에서 Queue는 추상클래스 이므로 LinkedList로 생성자를 만들어야 합니다!
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10845 {
    private static Queue <Integer> queue = new LinkedList<>();
    static int lastPushed = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] commands = new String[n];
        for (int i = 0; i < n; i++) {
            commands[i] = br.readLine();
        }

        for (String command: commands) {
            handleCommands(command);
        }

    }
    private static void handleCommands(String command) {
        String[] parts = command.split(" ");

        if(parts[0].compareTo("push") == 0) {
            queue.offer(Integer.parseInt(parts[1]));
            lastPushed = Integer.parseInt(parts[1]);
        } else if (parts[0].compareTo("pop") == 0){
            if (queue.isEmpty()) {
                System.out.println("-1");
            }else {
                System.out.println(queue.poll());
            }
        } else if (parts[0].compareTo("size")== 0) {
            System.out.println(queue.size());
        } else if (parts[0].compareTo("empty") == 0) {
            if (queue.isEmpty()) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        } else if (parts[0].compareTo("front") == 0) {
            if (queue.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(queue.peek());
            }
        } else { // "back"
            if (queue.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(lastPushed);
            }
        }
    }
}//3월 12일에 꼭 풀기!
