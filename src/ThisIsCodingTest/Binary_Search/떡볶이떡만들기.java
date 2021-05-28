/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
   public static int binSearch(int[] arr, int m, int start, int end) {
   		int ans = 0;
    	while (start <= end) {
        	int mid = (start+end)/2;
        	int sub = getSubSum(arr, mid);
        	if(sub < m){
        		end = mid - 1;
        	}
        	else {
        		ans = mid;
         		start = mid + 1;
        	}
    	}
    	return ans;
   }
   public static int getSubSum (int[] arr, int mid) {
      int ans = 0;
      for (int i = 0; i < arr.length; i++) {
         if(arr[i] > mid) ans += (arr[i]-mid);
      }
      return ans;
   }
   public static void main (String[] args) throws java.lang.Exception
   {
      Scanner sc = new Scanner (System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i ++) {
         arr[i] = sc.nextInt();
      }
      int ans = binSearch(arr, m, 0, arr[n-1]);
      
      System.out.println(ans);
   }
}