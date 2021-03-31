package boj;

import java.util.Scanner;

public class Main_2304_배수연 {
	static int N;
	static int[][] map = new int[1001][1001];
	static int[] sticks;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sticks = new int[1001];
		int min_L = Integer.MAX_VALUE;
		int max_L = 0;
		int max_H = 0;
		int max_H_idx = 0;
		for(int n = 0 ; n<N ; n++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			sticks[L] = H;
			max_L = Math.max(max_L, L);
			min_L = Math.min(min_L, L);
			max_H = Math.max(max_H, H);
			if(sticks[L]>sticks[max_H_idx]) max_H_idx = L;
		}
		
		int sum = 0;
		int curr = 0;
		for(int i = min_L ; i<max_H_idx ; i++) {
			curr = Math.max(curr, sticks[i]);
			sum += curr;
		}
		curr = 0;
		for(int i = max_L ; i>max_H_idx ; i--) {
			curr = Math.max(curr, sticks[i]);
			sum += curr;
		}
		
		int ans = sticks[max_H_idx] + sum;
		System.out.println(ans);
		
	}

}
