package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_3055 {
	static int R, C, ans;
	static int end_x, end_y;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> dochi, water;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		dochi = new LinkedList<int[]>();
		water = new LinkedList<int[]>();
		for(int r = 0 ; r<R ; r++) {
			String line = br.readLine();
			for(int c = 0 ; c<C ; c++) {
				map[r][c] = line.toCharArray()[c];
				if(map[r][c] == 'D') {
					end_x = r;
					end_y = c;
				}
				if(map[r][c] == 'S') dochi.offer(new int[] {r, c, 0});
				if(map[r][c] == '*') water.offer(new int[] {r, c});
			}
		}
		ans = Integer.MIN_VALUE;
		BFS();
		System.out.println((ans == Integer.MIN_VALUE)? "KAKTUS" : ans);
	}

	private static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[dochi.peek()[0]][dochi.peek()[1]] = true;
		while(!dochi.isEmpty() || !water.isEmpty()) {
			while(!water.isEmpty()) {
				queue.offer(water.poll());
			}
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				for(int d = 0 ; d<4 ; d++) {
					int nr = temp[0]+dr[d];
					int nc = temp[1]+dc[d];
					if(nr>-1 && nr<R && nc>-1 && nc<C && map[nr][nc] == '.') {
						water.offer(new int[] {nr, nc});
						map[nr][nc] = '*';
					}
				}
			}
			while(!dochi.isEmpty()) {
				queue.offer(dochi.poll());
			}
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				if(temp[0] == end_x && temp[1] == end_y) {
					ans = temp[2];
					return;
				}
				for(int d = 0 ; d<4 ; d++) {
					int nr = temp[0]+dr[d];
					int nc = temp[1]+dc[d];
					if(nr>-1 && nr<R && nc>-1 && nc<C && !visited[nr][nc]) {
						if(map[nr][nc] != '*' && map[nr][nc] != 'X') {
							dochi.offer(new int[] {nr, nc, temp[2]+1});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
	}

}
