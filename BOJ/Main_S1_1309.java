package boj;

import java.util.Scanner;

public class Main_S1_1309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] cage = new long[N+1][3]; // [][0] : 해당 줄에 사자가 없으면 0, 1칸은 1, 2칸은 2
		
		cage[1][0] = cage[1][1] = cage[1][2] = 1;
		for(int n = 2 ; n<=N ; n++) {
			cage[n][0] = (cage[n-1][0]+cage[n-1][1]+cage[n-1][2])%9901;
			cage[n][1] = (cage[n-1][0]+cage[n-1][2])%9901;
			cage[n][2] = (cage[n-1][0]+cage[n-1][1])%9901;
		}
		long ans = (cage[N][0]+cage[N][1]+cage[N][2])%9901;
		System.out.println(ans);
	}

}
