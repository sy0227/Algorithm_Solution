package boj;

import java.util.Scanner;

public class Main_B2_3040 {
	static int[] people = new int[9];
	static int[] numbers = new int[7];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i<9 ; i++) {
			people[i] = sc.nextInt();
		}
		comb(0, 0);
	}
	private static void comb(int idx, int start) {
		if(idx == 7) {
			if(sum(numbers) == 100) {
				for (int i : numbers) {
					System.out.println(i);
				}
			}
			return;
		}
		for(int i = start ; i<9 ; i++) {
			numbers[idx] = people[i];
			comb(idx+1, i+1);
		}
	}
	private static int sum(int[] arr) {
		int sum = 0;
		for(int i = 0 ; i<7 ; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
