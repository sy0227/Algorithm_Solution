package boj;

import java.util.Scanner;

public class Main_B1_2748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] fibo = new long[N+1];
		if(N<=1) {
			System.out.println(N);
			return;
		}
		fibo[1] = 1;
		for(int i = 2 ; i<=N ; i++) {
			fibo[i] = fibo[i-2]+fibo[i-1];
		}
		System.out.println(fibo[N]);
	}

}
