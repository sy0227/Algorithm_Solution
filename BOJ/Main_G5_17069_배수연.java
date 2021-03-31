package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G5_17069_배수연 {
	static int N;
	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N][3]; // 가로, 대각선, 세로
		for(int i = 0 ; i<N ; i++) {
			String line = br.readLine();
			for(int j = 0, k = 0 ; j<N ; j++, k+=2) {
				map[i][j] = line.charAt(k)-'0';
			}
		}

		dp[0][1][0] = 1;
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				if(isPossible(i, j+1)) dp[i][j+1][0] += dp[i][j][0]+dp[i][j][1];
				if(isPossible(i+1, j)) dp[i+1][j][2] += dp[i][j][1]+dp[i][j][2];
				if(isPossible(i, j+1) && isPossible(i+1, j) && isPossible(i+1, j+1)) dp[i+1][j+1][1] += dp[i][j][0]+dp[i][j][1]+dp[i][j][2];
			}
		}
		
		long ans = 0;
		for(int i = 0 ; i<3 ; i++) {
			ans += dp[N-1][N-1][i];
		}
		System.out.println(ans);
	}

	private static boolean isPossible(int r, int c) {
		if(r>-1 && r<N && c>-1 && c<N && map[r][c] == 0) return true;
		return false;
	}
}
