import java.util.*;

public class boj_1024 {
    public static void main(String args[]) {
        int n, l;

        Scanner sc = new Scanner (System.in);
        n = sc.nextInt();
        l = sc.nextInt();

        int mid = n/l;
        int sit = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(true) {
            int sum = 0;
            mid = n/l;
            
            if (l > 100) {
                ans.add(-1);
                sit = -1;
                break;
            }
            // l이 짝수인 경우 mid가 왼쪽가운데/오른쪽가운데 인 경우로 나누어 생각
            if(l % 2 == 0) {
                sum = (mid + mid+1) * (l/2); // 왼.가
                // System.out.println(sum);
                if (sum == n) {
                    sit = 1;
                    break;
                }
                else {
                    sum = (mid -1 + mid) * (l/2); // 오.가
                }
                // System.out.println(sum);
                if (sum == n) {
                    sit = 2;
                    break;
                }
            }

            // l이 홀수인 경우 mid가 가운데인 경우
            if (l%2 == 1) {
                sum = mid + ((2*mid) * (l/2)); // 가
                // System.out.println(mid+" "+2*mid+" "+(2*mid) * l/2+" "+sum);
                if (sum == n) {
                    sit = 3;
                    break;
                }
            }
            
            l++;
        }
        if (sit != -1 && sit != 0) {
            int first = 0;
            if(sit == 1) {
                first = mid - (l/2-1);
            } else if (sit == 2 || sit == 3) {
                first = mid - (l/2);
            }
            if (first < 0) ans.add(-1);
            else {
                for(int i = 0; i < l; i++) {
                ans.add(first++);
                }
            }
        }

        for (int i : ans) {
            System.out.print(i + " ");
        }

    }
    
    

}
