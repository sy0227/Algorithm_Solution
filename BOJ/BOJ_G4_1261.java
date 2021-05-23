package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 알고스팟
 */
public class BOJ_G4_1261 {
	static int N, M;
	static boolean[][] map, visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pos implements Comparable<Pos> {
		int r, c, cnt;
		public Pos(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Pos o) {
			return this.cnt-o.cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		visited = new boolean[N][M];
		for(int n = 0 ; n<N ; n++) {
			String line = br.readLine();
			for(int m = 0 ; m<M ; m++) {
				if(line.charAt(m)-'0' == 0) map[n][m] = true;
			}
		}
		System.out.println(BFS());
	}

	private static int BFS() {
		PriorityQueue<Pos> queue = new PriorityQueue<Pos>();
		queue.offer(new Pos(0, 0, 0));
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			Pos temp = queue.poll();
			int temp_r = temp.r;
			int temp_c = temp.c;
			int temp_cnt = temp.cnt;
			if(temp_r == N-1 && temp_c == M-1) {
				if(temp_cnt == 0) return 0;
				return temp_cnt;
			}
			for(int d = 0 ; d<4 ; d++) {
				int nr = temp_r+dr[d];
				int nc = temp_c+dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc]) {
					if(!map[nr][nc]) queue.offer(new Pos(nr, nc, temp_cnt+1));
					else queue.offer(new Pos(nr, nc, temp_cnt));
					visited[nr][nc] = true;
				}
			}
		}
		return 0;
	}
}
