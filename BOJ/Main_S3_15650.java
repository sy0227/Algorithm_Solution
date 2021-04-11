package boj;

import java.util.*;
/** 조합 */

public class Main_S3_15650 {
	static int N, M;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		func(0, 1);
	}
	public static void func(int idx, int start) {
		if(idx == M) {
			for(int i = 0 ; i<M ; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = start ; i<=N ; i++) {
			numbers[idx] = i;
			func(idx+1, i+1);
		}
	}

}
