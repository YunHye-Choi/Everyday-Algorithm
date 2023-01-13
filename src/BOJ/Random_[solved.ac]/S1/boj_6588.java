import java.util.*;
import java.io.*;

public class boj_6588
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[1000001];
        for(int i = 2; i < prime.length; i ++){
            prime[i] = isPrime(i);
        }
        
		while (true){
			int num = sc.nextInt();
			if(num == 0) {
				break;
			}
			boolean ans = false;
			for (int i = 2; i <= num/2 ; i ++){
				if (prime[i] && prime[num-i]){
					System.out.println(String.format("%s = %s + %s", num, i, num-i));
                    ans = true;
					break;
				}
			}
			if (!ans) System.out.println("Goldbach's conjecture is wrong.");
		}
		
	}
	public static boolean isPrime(int number) {
		return number > 1
		&& java.util.stream.IntStream.rangeClosed(2, (int)Math.sqrt(number))
					.noneMatch(n -> number%n == 0);
	}
}