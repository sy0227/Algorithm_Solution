package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7576 {
	static int N, M, ans;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Pos> tomato;
	
	static class Pos {
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tomato = new LinkedList<Pos>();
		ans = 0;
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 1) {
					tomato.offer(new Pos(n, m));
				}
			}
		}
		
		BFS();
		
		for(int n = 0 ; n<N ; n++) {
			for(int m = 0 ; m<M ; m++) {
				if(map[n][m] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(ans-1);
		
	}

	private static void BFS() {
		while(!tomato.isEmpty()) {
			for(int i = 0, size = tomato.size() ; i<size ; i++) {
				Pos temp = tomato.poll();
				int temp_x = temp.x;
				int temp_y = temp.y;
				
				int nr = 0, nc = 0;
				for(int d = 0 ; d<4 ; d++) {
					nr = temp_x+dr[d];
					nc = temp_y+dc[d];
					if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] == 0) {
						tomato.offer(new Pos(nr, nc));
						map[nr][nc] = 1;
					}
				}
			}
			ans++;
		}
	}

}
