package boj;

import java.util.Scanner;

public class Main_G3_1300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int ans = 0;
		int left = 1, right = K;
		while(left<=right) {
			int mid = (left+right)/2;
			long sum = 0;
			for(int n = 1 ; n<=N ; n++) {
				sum += Math.min(N, mid/n);
			}
			if(sum >= K) {
				right = mid-1;
				ans = mid;
			}
			else left = mid+1;
		}
		System.out.println(ans);
	}

}
