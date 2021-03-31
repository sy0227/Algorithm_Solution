package boj;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_B1_14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[2][5];
		String result;
		for(int n = 0 ; n<N ; n++) {
			Arrays.fill(arr[0], 0);
			Arrays.fill(arr[1], 0);
			for(int i = 0 ; i<2 ; i++) {
				int d = sc.nextInt();
				for(int j = 0 ; j<d ; j++) {
					arr[i][sc.nextInt()]++;
				}
			}
			result = "D";
			for(int i = 4 ; i>0 ; i--) {
				if(arr[0][i]>arr[1][i]) {
					result = "A";
					break;
				}
				else if(arr[0][i]<arr[1][i]) {
					result = "B";
					break;
				}
			}
			System.out.println(result);
		}
	}

}
