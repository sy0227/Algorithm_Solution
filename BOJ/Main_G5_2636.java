package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2636 {
	static int H, W, time, cheese, edge;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(str));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[W][H];
		time = 0;
		cheese = 0;
		edge = 0;
		for(int w = 0 ; w<W ; w++) {
			st = new StringTokenizer(br.readLine());
			for(int h = 0 ; h<H ; h++) {
				map[w][h] = Integer.parseInt(st.nextToken());
				if(map[w][h] == 1) cheese++;
			}
		}
		int prev_cheese = cheese;
		while(cheese > 0) {
			prev_cheese = cheese;
			BFS();
			meltCheese();
			time++;
			cheese -= edge;
		}
		System.out.println(time);
		System.out.println(prev_cheese);
	}
	private static void BFS() {
		visited = new boolean[W][H];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_r = temp[0];
			int temp_c = temp[1];
			if(map[temp_r][temp_c] == 1) continue;
			for(int d = 0 ; d<4 ; d++) {
				int nr = temp_r + dr[d];
				int nc = temp_c + dc[d];
				if(nr>-1 && nr<W && nc>-1 && nc<H && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
	}
	private static void meltCheese() {
		edge = 0;
		for(int w = 0 ; w<W ; w++) {
			for(int h = 0 ; h<H ; h++) {
				if(visited[w][h]) {
					if(map[w][h] == 1) edge++;
					map[w][h] = 0;
				}
			}
		}
	}
	static String str = "13 12\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";

}
