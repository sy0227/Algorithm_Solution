package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {
	static int N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] pipe = { // 상하좌우
			{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1},
			{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}, {1, 0, 1, 0}
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int n = 0 ; n<N ; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m = 0 ; m<M ; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			BFS();
			
			ans = 0;
			for(int n = 0 ; n<N ; n++) {
				for(int m = 0 ; m<M ; m++) {
					if(visited[n][m]) ans++;
				}
			}
			System.out.println("#" + test + " " + ans);
		}
	}

	private static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {R, C, 1});
		visited[R][C] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			int temp_time = temp[2];
			if(temp_time == L) break;
			
			int nr = 0, nc = 0;
			for(int d = 0 ; d<4 ; d++) {
				boolean isPossible = false;
				nr = temp_x+dr[d];
				nc = temp_y+dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc]) {
					if(pipe[map[temp_x][temp_y]][d] == 1) {
						int next_pipe = map[nr][nc];
						if(next_pipe > 0) {
							// 현재 탐색 방향 d가 상일 때, next_pipe의 하 방향이 1이어야 한다.
							if(d == 0 && pipe[next_pipe][1] == 1) isPossible = true;
							// 현재 탐색 방향 d가 하일 때, next_pipe의 상 방향이 1이어야 한다.
							else if(d == 1 && pipe[next_pipe][0] == 1) isPossible = true;
							// 현재 탐색 방향 d가 좌일 때, next_pipe의 우 방향이 1이어야 한다.
							else if(d == 2 && pipe[next_pipe][3] == 1) isPossible = true;
							// 현재 탐색 방향 d가 우일 때, next_pipe의 좌 방향이 1이어야 한다.
							else if(d == 3 && pipe[next_pipe][2] == 1) isPossible = true;
						}
					}
				}
				if(isPossible) {
					queue.offer(new int[] {nr, nc, temp_time+1});
					visited[nr][nc] = true;
				}
			}
					
		}
	}

}
