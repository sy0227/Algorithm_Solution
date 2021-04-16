package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105 {
	static int N, ans;
	static int start_r, start_c;
	static int[][] map;
	static boolean[] visitedD = new boolean[101];
	static int[] dr = {1, 1, -1, -1}; // 우하, 좌하, 좌상, 우상
	static int[] dc = {1, -1, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j<N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = -1;
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					visitedD[map[i][j]] = true;
					start_r = i;
					start_c = j;
					DFS(i, j, 1, 0);
					visitedD[map[i][j]] = false;
				}
			}
			System.out.println("#" + test + " " + ans);
		}
	}

	private static void DFS(int r, int c, int cnt, int dir) {
		int nr = r+dr[dir];
		int nc = c+dc[dir];
		if(nr == start_r && nc == start_c && dir == 3) {
			ans = Math.max(ans, cnt);
			return;
		}
		if(nr>-1 && nr<N && nc>-1 && nc<N && !visitedD[map[nr][nc]]) {
			visitedD[map[nr][nc]] = true;
			DFS(nr, nc, cnt+1, dir);
			if(dir<3) DFS(nr, nc, cnt+1, dir+1);
			visitedD[map[nr][nc]] = false;
		}
	}
}
