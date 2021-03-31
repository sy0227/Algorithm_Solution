package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B2_2309 {
//	static int[] people = new int[9];
//	static int[] numbers = new int[7];
//	static boolean flag = false;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		for(int i = 0 ; i<9 ; i++) {
//			people[i] = Integer.parseInt(br.readLine());
//		}
//		comb(0, 0);
//	}
//	private static void comb(int idx, int start) {
//		if(idx == 7) {
//			if(sum(numbers) == 100 && !flag) {
//				Arrays.sort(numbers);
//				flag = true;
//				for (int i : numbers) {
//					System.out.println(i);
//				}
//			}
//			return;
//		}
//		for(int i = start ; i<9 ; i++) {
//			numbers[idx] = people[i];
//			comb(idx+1, i+1);
//		}
//	}
//	private static int sum(int[] arr) {
//		int sum = 0;
//		for(int i = 0 ; i<arr.length ; i++) {
//			sum += arr[i];
//		}
//		return sum;
//	}
	static int[] people = new int[9];
	static int[] numbers = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i<9 ; i++) {
			people[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);
	}
	public static void comb(int idx, int start) {
		if(idx == 7) {
			int sum = 0;
			for(int i = 0 ; i<7 ; i++) {
				sum += numbers[i];
			}
			if(sum == 100) {
				Arrays.sort(numbers);
				for(int i = 0 ; i<7 ; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		for(int i = start ; i<9 ; i++) {
			numbers[idx] = people[i];
			comb(idx+1, i+1);
		}
	}

}
