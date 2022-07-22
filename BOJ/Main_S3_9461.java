package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_9461 {
	static long[] DP = new long[101];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		getDP();
		for(int test = 0 ; test<T ; test++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(DP[N]);
		}
	}

	private static void getDP() {
		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 1;
		for(int i = 3 ; i<=100 ; i++) {
			DP[i] = DP[i-2]+DP[i-3];
		}
	}

}
