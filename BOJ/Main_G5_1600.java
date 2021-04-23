package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_1600 {
	static int K, W, H, ans;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {0, 0, -1, 1, 1, -1, 2, -2, 2, -2, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int h = 0 ; h<H ; h++) {
			st = new StringTokenizer(br.readLine());
			for(int w = 0 ; w<W ; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}
		BFS();
		System.out.println(ans);
	}

	private static void BFS() {
		ans = -1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0, 0, 0}); // x, y, k, cnt
		visited[0][0][0] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			int temp_k = temp[2];
			int temp_cnt = temp[3];
			
			if(temp_x == H-1 && temp_y == W-1) {
				ans = temp_cnt;
				return;
			}
			
			int possibleK = (temp_k >= K)? 4 : 12;
			int nr = 0, nc = 0;
			for(int d = 0 ; d<possibleK ; d++) {
				nr = temp_x+dr[d];
				nc = temp_y+dc[d];
				if(nr>-1 && nr<H && nc>-1 && nc<W && map[nr][nc] != 1) {
					// 원숭이 이동
					if(d<4) {
						if(!visited[nr][nc][temp_k]) {
							queue.offer(new int[] {nr, nc, temp_k, temp_cnt+1});
							visited[nr][nc][temp_k] = true;
						}
					}
					// 말 이동
					else {
						int new_k = temp_k+1;
						if(!visited[nr][nc][new_k]) {
							queue.offer(new int[] {nr, nc, new_k, temp_cnt+1});
							visited[nr][nc][new_k] = true;
						}
					}
				}
			}
		}
		
	}

}
