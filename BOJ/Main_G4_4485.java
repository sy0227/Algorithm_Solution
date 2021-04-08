package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_4485 {
	static int N;
	static int[][] map, visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
        int test = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			visited = new int[N][N];
			for(int r = 0 ; r<N ; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0 ; c<N ; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					visited[r][c] = Integer.MAX_VALUE;
				}
			}
			BFS();
			
			System.out.println("Problem " + (test++) + ": " + visited[N-1][N-1]);
		}
	}

	private static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0, 0});
		visited[0][0] = map[0][0];
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_r = temp[0];
			int temp_c = temp[1];
			int temp_cost = temp[2];
			if(visited[temp_r][temp_c]<temp_cost) continue;
			for(int d = 0 ; d<4 ; d++) {
				int nr = 0, nc = 0;
				nr = temp_r+dr[d];
				nc = temp_c+dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<N) {
					if(visited[nr][nc]>visited[temp_r][temp_c]+map[nr][nc]) {
						visited[nr][nc] = visited[temp_r][temp_c]+map[nr][nc];
						queue.offer(new int[] {nr, nc, visited[nr][nc]});
					}
				}
			}
		}
	}
}
