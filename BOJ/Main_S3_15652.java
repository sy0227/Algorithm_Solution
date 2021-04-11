package boj;

import java.util.*;
/** 조합 */

public class Main_S3_15652 {
	static int N, M;
	static int[] numbers;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		func(0, 1);
		System.out.println(sb.toString());
	}

	private static void func(int idx, int start) {
		if(idx == M) {
			for(int i = 0 ; i<M ; i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start ; i<=N ; i++) {
			numbers[idx] = i;
			func(idx+1, i);
		}
	}

}
