/* package whatever; // don't place package name! */
// 석민이가 제시한 아이디어로 빠르게 풀었다.
// 다음 문제부터는 본격적으로 혼자 생각해서 풀어본다!
import java.util.Arrays;

class Ideone {
    public static void main (String args[]){
        int n = 5, m = 8, k = 3;
        int arr[] = {2, 4, 5, 4, 6};
        
        Arrays.sort(arr);
        
        int max = arr[n-1];
        int secondMax = arr[n-2];
        int sol = 0, cntMax = 0;
        for (int i = 0; i < m; i ++) {
        	if (cntMax < k) {
        		sol += max;
        		cntMax++;
        	}
        	else {
        		sol += secondMax;
        		cntMax = 0;
        	}
        }
        
        System.out.println(sol);
        
    }
}