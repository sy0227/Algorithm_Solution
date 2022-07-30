package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14503 {
	static int N, M, r, c, d;
	static int[][] map;
	static int cnt = 1;
	static int[] dr = {-1, 0, 1, 0}; // 북동남서
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(r, c, d);
		System.out.println(cnt);
	}

	private static void DFS(int r, int c, int d) {
		map[r][c] = 2;
		for(int i = 0 ; i<4 ; i++) {
			d = (d+3)%4;
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] == 0) {
				cnt++;
				DFS(nr, nc, d);
				return;
			}
		}
		int back = (d+2)%4;
		int br = r+dr[back];
		int bc = c+dc[back];
		if(br>=0 && br<N && bc>=0 && bc<M && map[br][bc] != 1) DFS(br, bc, d);
	}

}
