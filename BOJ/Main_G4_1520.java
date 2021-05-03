package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1520 {
	static int M, N;
	static int[][] map;
	static int[][] DP;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		DP = new int[M][N];
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			for(int n = 0 ; n<N ; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
				DP[m][n] = -1;
			}
		}
		func(0, 0);
		System.out.println(DP[0][0]);
	}

	private static int func(int i, int j) {
		if(i == M-1 && j == N-1) return 1;
		if(DP[i][j]>-1) return DP[i][j];
		
		int temp = 0;
		for(int d = 0 ; d<4 ; d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			if(nr>-1 && nr<M && nc>-1 && nc<N) {
				if(map[nr][nc]<map[i][j]) temp += func(nr, nc);
			}
		}
		return DP[i][j] = temp;
	}


}
/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
*/