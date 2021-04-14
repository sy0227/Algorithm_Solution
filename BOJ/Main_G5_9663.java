package boj;

import java.util.Scanner;

public class Main_G5_9663 {
	static int ans, N;
	static int[] col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		setQueen(0);
		System.out.println(ans);
	}

	private static void setQueen(int rowNo) {
		if(!isAvailable(rowNo)) return;
		if(rowNo == N) {
			ans++;
			return;
		}
		for(int i = 1 ; i<=N ; i++) {
			col[rowNo+1] = i;
			setQueen(rowNo+1);
		}
	}

	private static boolean isAvailable(int rowNo) {
		for(int i = 1 ; i<rowNo ; i++) {
			if(col[rowNo] == col[i] || Math.abs(col[rowNo]-col[i]) == rowNo-i) return false;
		}
		return true;
	}
}
