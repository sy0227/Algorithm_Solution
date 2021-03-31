package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_S4_10826 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger[] fibo = new BigInteger[N+1];
		if(N<=1) {
			System.out.println(N);
			return;
		}
		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;
		for(int i = 2 ; i<=N ; i++) {
			fibo[i] = fibo[i-2].add(fibo[i-1]);
		}
		System.out.println(fibo[N]);
	}

}
