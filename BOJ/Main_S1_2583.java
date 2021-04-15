package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S1_2583 {
	static int M, N, area;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int k = 0 ; k<K ; k++) {
			st = new StringTokenizer(br.readLine());
			int left_x = Integer.parseInt(st.nextToken());
			int left_y = Integer.parseInt(st.nextToken());
			int right_x = Integer.parseInt(st.nextToken());
			int right_y = Integer.parseInt(st.nextToken());
			for(int r = left_y ; r<right_y ; r++) {
				for(int c = left_x ; c<right_x ; c++) {
					map[r][c] = 1;
				}
			}
		}
		
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		List<Integer> answer = new LinkedList<Integer>();
		for(int m = 0 ; m<M ; m++) {
			for(int n = 0 ; n<N ; n++) {
				if(map[m][n] == 0 && !visited[m][n]) {
					area = 0;
					DFS(m, n);
					answer.add(area);
				}
			}
		}
		
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for (Integer num : answer) {
			System.out.print(num+" ");
		}
		
	}

	private static void DFS(int r, int c) {
		area++;
		visited[r][c] = true;
		int nr = 0, nc = 0;
		for(int d = 0 ; d<4 ; d++) {
			nr = r+dr[d];
			nc = c+dc[d];
			if(nr>-1 && nr<M && nc>-1 && nc<N && map[nr][nc] == 0 && !visited[nr][nc]) {
				DFS(nr, nc);
			}
		}
	}

}
