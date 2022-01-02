import java.util.*;
public class boj_1052 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        int sit = 0;
        while(true) {
            n += ans;
            if (n % 2 == 1) {
                ans ++;
                continue;
            }
            if (n % 2 == 0) {
                int _n = n;
                while(true) {
                    _n /= 2;
                    if(_n == k) {
                        sit = 1;
                        break;
                    }
                    if (_n % 2 == 1) {
                        sit = -1;
                        break;
                    }
                }
                if (sit == 1) {
                    break;
                } else {
                    ans ++;
                    continue;
                }
            }
        }
        System.out.println(ans+1);
    }
}
