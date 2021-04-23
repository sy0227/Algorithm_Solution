package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699 {
	static int R, C, ans;
	static char[][] map;
	static boolean[] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new char[R][C];
			visited = new boolean[26];
			for(int r = 0 ; r<R ; r++) {
				map[r] = br.readLine().toCharArray();
			}
			
			visited[map[0][0]-'A'] = true;
			DFS(0, 0, 1);
			System.out.println("#"+test+" "+ans);
		}
	}

	private static void DFS(int r, int c, int cnt) {
		int nr = 0, nc = 0;
		for(int d = 0 ; d<4 ; d++) {
			nr = r+dr[d];
			nc = c+dc[d];
			if(nr>-1 && nr<R && nc>-1 && nc<C && !visited[map[nr][nc]-'A']) {
				visited[map[nr][nc]-'A'] = true;
				DFS(nr, nc, cnt+1);
				visited[map[nr][nc]-'A'] = false;
			}
		}
		ans = Math.max(ans, cnt);
	}

}
