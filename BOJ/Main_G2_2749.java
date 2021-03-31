package boj;

import java.util.Scanner;

/** 피사노 주기를 이용한 피보나치 수 */

public class Main_G2_2749 {
	static int P = 1000000/10*15;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long[] fibo = new long[P];
		if(N<=1) {
			System.out.println(N);
			return;
		}
		fibo[1] = 1;
		for(int i = 2 ; i<P ; i++) {
			fibo[i] = fibo[i-2]+fibo[i-1];
			fibo[i] %= 1000000;
		}
		System.out.println(fibo[(int) (N%P)]);
	}

}
