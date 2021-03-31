package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G1_20304 {
	static int N, M;
	static int[] password;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int min_sec = 100000000;
		password = new int[M];
		for(int m = 0 ; m<M ; m++) {
			password[m] = Integer.parseInt(st1.nextToken());
		}

		for(int i = 0 ; i<N ; i++) {
			int temp_sec = 1000000000;
			for(int m = 0 ; m<M ; m++) {
				int sec = 0;
				for(int j = 0 ; j<=100 ; j++) {
					if((password[m] != i) && ((i&1<<j) != (password[m]&1<<j))) sec++;
				}
				temp_sec = Math.min(temp_sec, sec); // N에 대한 보안척도 최소값
			}
			min_sec = Math.min(min_sec, temp_sec); // 보안척도가 가장 작은 값
		}
		
		System.out.println(min_sec);
	}

}
