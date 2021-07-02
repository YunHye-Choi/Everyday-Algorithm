package programmers;

import java.util.*;

public class p_42895 {
	public static int solution(int n, int num) {
		int ans = 0;
		ArrayList <HashSet<Integer>> list = new ArrayList<>();
		HashSet <Integer> set = new HashSet<>();
		set.add(n);
		list.add(set);
		
		while(ans < 8) {
			if(list.get(ans).contains(num)) break;
			ans++;
			
			HashSet <Integer> nset = new HashSet<>();
			String s = "";
			for(int i = 0; i < ans + 1; i++) s += String.valueOf(n);
			nset.add(Integer.parseInt(s));
			
			for(int i = 0; i <= ans / 2; i++) {
				for(int j = 0; i + j < ans; j++) {
					for(Iterator it1 = list.get(i).iterator(); it1.hasNext();) {
						int op1 = (int)it1.next();
						for(Iterator it2 = list.get(j).iterator(); it2.hasNext();) {
							int op2 = (int)it2.next();
							nset.add(op1 + op2);
							nset.add(op1 - op2);
							nset.add(op1 * op2);
							if(op2 != 0) nset.add(op1 / op2);
						}
					}
				}
			}
			list.add(nset);
		}
		
		return (ans >= 8) ? -1 : ans + 1;
	}
	public static void main(String[] args) {
		int n = 5;
		int num = 12;
		int n2 = 9;
		int num2 = 32490;
		
		System.out.println(solution(n, num));
	}
}