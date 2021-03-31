package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1012 {
	static int T, M, N, K, X, Y;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			cnt = 0;
			for(int k = 0 ; k<K ; k++) {
				st = new StringTokenizer(br.readLine());
				Y = Integer.parseInt(st.nextToken());
				X = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
			}
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<M ; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 0;
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void DFS(int r, int c) {
		for(int d = 0 ; d<4 ; d++) {
			int nr, nc;
			nr = r+dr[d];
			nc = c+dc[d];
			if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] == 1) {
				map[nr][nc] = 0;
				DFS(nr, nc);
			}
		}
		
	}

}
