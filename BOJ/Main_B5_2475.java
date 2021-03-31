package boj;

import java.util.Scanner;

public class Main_B5_2475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = 0;
		long sum = 0;
		for(int i = 0 ; i<5 ; i++) {
			num = sc.nextLong();
			sum += num*num;
		}
		System.out.println(sum%10);
	}

}
