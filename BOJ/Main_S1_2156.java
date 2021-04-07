package boj;

import java.util.Scanner;

public class Main_S1_2156 {
	static int[] num;
	static long[] DP = new long[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		num = new int[N+1];
		for(int n = 1 ; n<=N ; n++) {
			num[n] = sc.nextInt();
		}
		if(N == 1) DP[1] = num[1];
		if(N == 2) DP[2] = num[1]+num[2];
		if(N >= 3) {
			DP[1] = num[1];
			DP[2] = num[1]+num[2];
			for(int n = 3 ; n<=N ; n++) {
				DP[n] = Math.max(Math.max(DP[n-1], DP[n-2]+num[n]), DP[n-3]+num[n-1]+num[n]);
			}
		}
		System.out.println(DP[N]);
	}

}
