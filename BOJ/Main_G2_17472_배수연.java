package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_17472_배수연 {
	static int N, M, min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int island = 2;
		for(int n = 0 ; n<N ; n++) {
			for(int m = 0 ; m<M ; m++) {
				if(map[n][m] == 1) {
					diffIsland(n, m, island);
					island++;
				}
			}
		}
		
		for(int i = 0 ; i<island ; i++) {
			for(int j = 0 ; j<island ; j++) {
				
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int land = 2 ; land<island ; land++) {
			min = Math.min(min, BFS(land));
		}
		System.out.println(min);
	}
	private static void diffIsland(int r, int c, int island) {
		map[r][c] = island;
		for(int d = 0 ; d<4 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] == 1) {
				diffIsland(nr, nc, island);
			}
		}
	}
	private static int BFS(int land) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int len = 0;
		for(int n = 0 ; n<N ; n++) {
			for(int m = 0 ; m<M ; m++) {
				if(map[n][m] == land && !visited[n][m]) queue.offer(new int[] {n, m, 0});
			}
		}
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_r = temp[0];
			int temp_c = temp[1];
			len = temp[2];
			for(int d = 0 ; d<4 ; d++) {
				int nr = temp_r + dr[d];
				int nc = temp_c + dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc]) {
					
				}
			}
		}
		
		return 0;
	}
}
