package boj;

import java.util.Scanner;

public class Main_S3_15649 {
	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		isSelected = new boolean[N+1];
		
		
//		func1_selected(0);
		func2_bit(0, 0);
		
		System.out.println(sb.toString());
	}
	
	private static void func1_selected(int idx) {
		if(idx == M) {
			for(int i = 0 ; i<M ; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1 ; i<=N ; i++) {
			if(isSelected[i]) continue;
			numbers[idx] = i;
			isSelected[i] = true;
			func1_selected(idx+1);
			isSelected[i] = false;
		}
	}

	private static void func2_bit(int idx, int flag) {
		if(idx == M) {
			for(int i = 0 ; i<M ; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1 ; i<=N ; i++) {
			if((flag&1<<i) == 0) {
				numbers[idx] = i;
				func2_bit(idx+1, flag|1<<i);
			}
		}
	}
}
