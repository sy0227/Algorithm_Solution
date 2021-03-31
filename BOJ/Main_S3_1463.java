package boj;

import java.util.Scanner;

public class Main_S3_1463 {
	static int N;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N+1];
		
//		num[1] = 0;
		for(int i = 2 ; i<=N ; i++) {
			num[i] = num[i-1]+1;
			if(i%2 == 0 && num[i]>num[i/2]+1) num[i] = num[i/2]+1;
			if(i%3 == 0 && num[i]>num[i/3]+1) num[i] = num[i/3]+1;
		}
		System.out.println(num[N]);
	}
}
