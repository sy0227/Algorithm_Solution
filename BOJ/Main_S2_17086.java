package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_17086 {
	static int N, M;
	static int[][] map;
	static Queue<int[]> queue;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		queue = new LinkedList<int[]>();
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 1) queue.offer(new int[] {n, m});
			}
		}
		BFS();
		int ans = 0;
		for(int n = 0 ; n<N ; n++) {
			for(int m = 0 ; m<M ; m++) {
				ans = Math.max(ans, map[n][m]);
			}
		}
		System.out.println(ans-1);
	}

	private static void BFS() {
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int d = 0 ; d<8 ; d++) {
				int nr = temp[0]+dr[d];
				int nc = temp[1]+dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] == 0) {
					queue.offer(new int[] {nr, nc});
					map[nr][nc] = map[temp[0]][temp[1]]+1;
				}
			}
		}
	}

}
