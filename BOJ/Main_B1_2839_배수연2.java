package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B1_2839_배수연2 {
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sugar = new int[5001];
		Arrays.fill(sugar, 10000);
		sugar[3] = sugar[5] = 1;
		
		for(int i = 6 ; i<=N ; i++) {
			sugar[i] = Math.min(sugar[i-3], sugar[i-5])+1;
		}
		if(sugar[N]>=10000) System.out.println("-1");
		else System.out.println(sugar[N]);
	}
}
