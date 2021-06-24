package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_1915 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		int[][] DP = new int[N][M];
		int ans = 0;
		for(int n = 0 ; n<N ; n++) {
			String line = br.readLine();
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = (line.charAt(m)-'0' == 1)? true : false;
				DP[n][m] = line.charAt(m)-'0';
				if(map[n][m]) ans = 1;
			}
		}
		for(int n = 1 ; n<N ; n++) {
			for(int m = 1 ; m<M ; m++) {
				if(map[n][m]) {
					DP[n][m] = Math.min(DP[n][m-1], Math.min(DP[n-1][m], DP[n-1][m-1]))+1;
					ans = Math.max(ans, DP[n][m]);
				}
			}
		}
		System.out.println(ans*ans);
	}

}
