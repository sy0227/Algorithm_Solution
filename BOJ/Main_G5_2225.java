package boj;

import java.util.Scanner;

public class Main_G5_2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] dp = new long[N+1][K+1];
		if(K == 1) {
			System.out.println("1");
			return;
		}
		
		for(int i = 1 ; i<=K ; i++) {
			dp[0][i] = 1;
			if(N>0) dp[1][i] = i;
		}
		for(int i = 1 ; i<=N ; i++) {
			dp[i][1] = 1;
		}
		
		for(int i = 2 ; i<=N ; i++) {
			for(int j = 2 ; j<=K ; j++) {
				for(int k = 0 ; k<=i ; k++) {
					dp[i][j] += dp[i-k][j-1] % 1000000000;
				}
				dp[i][j] %= 1000000000;
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
