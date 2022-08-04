package BOJ;

import java.util.Scanner;

public class Main_G5_2293 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		int[] DP = new int[K+1];
		for(int n = 0 ; n<N ; n++) {
			coin[n] = sc.nextInt();
		}
		DP[0] = 1;
		for(int n = 0 ; n<N ; n++) {
			for(int k = 1 ; k<=K ; k++) {
				if(k>=coin[n]) DP[k] += DP[k-coin[n]];
			}
		}
		System.out.println(DP[K]);
	}

}
