package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_G3_2342 {
	static ArrayList<Integer> list;
	static int[][][] DP;
	static int[][] power = {
			{0, 2, 2, 2, 2},
			{0, 1, 3, 4, 3},
			{0, 3, 1, 3, 4},
			{0, 4, 3, 1, 3},
			{0, 3, 4, 3, 1}
	}; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<Integer>();
		while(true) {
			int num = sc.nextInt();
			if(num == 0) break;
			list.add(num);
		}
		DP = new int[list.size()][5][5];
		System.out.println(getDP(0, 0, 0));
	}

	private static int getDP(int idx, int left, int right) {
		if(idx == list.size()) return 0;
		if(DP[idx][left][right] != 0) return DP[idx][left][right];
		
		int temp = list.get(idx);
		int ans = Math.min(getDP(idx+1, left, temp)+power[right][temp], 
						getDP(idx+1, temp, right)+power[left][temp]);
		DP[idx][left][right] = ans;
		return DP[idx][left][right];
	}
}
