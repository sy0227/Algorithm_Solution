package boj;

import java.util.Scanner;

public class Main_B2_10448 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		arr = new int[51];
		for(int i = 1 ; i<=50 ; i++) {
			arr[i] = i*(i+1)/2;
		}
		
		for(int t = 1 ; t<=T ; t++) {
			int n = sc.nextInt();
			if(func(n)) System.out.println("1");
			else System.out.println("0");
		}
	}
	private static boolean func(int n) {
		
		for(int i = 1 ; i<arr.length ; i++) {
			for(int j = 1 ; j<arr.length ; j++) {
				for(int k = 1 ; k<arr.length ; k++) {
					if(arr[i]+arr[j]+arr[k] == n) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
