package boj;

import java.util.*;
/** 중복 순열 */

public class Main_S3_15651 {
	static int N, M;
	static int[] numbers;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		sb = new StringBuilder();
		func(0);
		System.out.println(sb.toString());
	}

	private static void func(int idx) {
		if(idx == M) {
			for(int i = 0 ; i<M ; i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1 ; i<=N ; i++) {
			numbers[idx] = i;
			func(idx+1);
		}
	}

}
