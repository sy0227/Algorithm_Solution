package BOJ;

import java.util.Scanner;

public class Main_B3_2522 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N-i-1 ; j++) {
				sb.append(" ");
			}
			for(int j = N-i-1 ; j<N ; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for(int i = 0 ; i<N-1 ; i++) {
			for(int j = 0 ; j<i+1 ; j++) {
				sb.append(" ");
			}
			for(int j = 0 ; j<N-i-1 ; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
