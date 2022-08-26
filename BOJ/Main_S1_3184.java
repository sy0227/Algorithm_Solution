package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_3184 {
	static char[][] map;
	static boolean[][] visited;
	static int R, C, totalW, totalS, wolf, sheep;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int r = 0 ; r<R ; r++) {
			String line = br.readLine();
			for(int c = 0 ; c<C ; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		for(int r = 0 ; r<R ; r++) {
			for(int c = 0 ; c<C ; c++) {
				wolf = 0;
				sheep = 0;
				if(!visited[r][c] && (map[r][c] == 'v' || map[r][c] == 'o' || map[r][c] == '.')) {
					solve(r, c);
				}
				if(sheep>wolf) wolf = 0;
				else sheep = 0;
				totalW += wolf;
				totalS += sheep;
			}
		}
		System.out.println(totalS + " " + totalW);
	}

	private static void solve(int r, int c) {
		visited[r][c] = true;
		if(map[r][c] == 'o') sheep++;
		else if(map[r][c] == 'v') wolf++;
		for(int d = 0 ; d<4 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				if(!visited[nr][nc] && (map[nr][nc] == 'v' || map[nr][nc] == 'o' || map[nr][nc] == '.')) {
					solve(nr, nc);
				}
			}
		}
	}
}
