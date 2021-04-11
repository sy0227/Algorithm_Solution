package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G5_10026 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		int normal = 0, GR = 0;
		for(int n = 0 ; n<N ; n++) {
			String line = br.readLine();
			for(int c = 0 ; c<N ; c++) {
				map[n][c] = line.toCharArray()[c];
			}
		}
		for(int r = 0 ; r<N ; r++) {
			for(int c = 0 ; c<N ; c++) {
				if(!visited[r][c]) {
					DFS(map[r][c], visited, r, c);
					normal++;
				}
				if(map[r][c] == 'G') map[r][c] = 'R';
			}
		}
		
		visited = new boolean[N][N];
		for(int r = 0 ; r<N ; r++) {
			for(int c = 0 ; c<N ; c++) {
				if(!visited[r][c]) {
					DFS(map[r][c], visited, r, c);
					GR++;
				}
			}
		}
		
		System.out.println(normal+" "+GR);
	}

	private static void DFS(char color, boolean[][] visited, int r, int c) {
		visited[r][c] = true;
		int nr = 0, nc = 0;
		for(int d = 0 ; d<4 ; d++) {
			nr = r+dr[d];
			nc = c+dc[d];
			if(nr>-1 && nr<N && nc>-1 && nc<N && !visited[nr][nc]) {
				if(map[nr][nc] == color) DFS(color, visited, nr, nc);
			}
		}
	}

}
