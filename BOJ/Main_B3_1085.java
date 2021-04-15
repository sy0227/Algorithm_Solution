package boj;

import java.util.Scanner;

public class Main_B3_1085 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int right_up_edge = Math.min(Math.abs(x-w), Math.abs(y-h));
		int left_down_edge = Math.min(x, y);
		int ans = Math.min(right_up_edge, left_down_edge);
		System.out.println(ans);
	}

}
