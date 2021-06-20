package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_16236 {
	static int N, ans;
	static boolean find;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Pair shark;
	static Queue<Pair> queue;
	static PriorityQueue<Pair> fishes;
	static int sharkSize, eatCnt;
	
	static class Pair implements Comparable<Pair>{
		int r, c, dist;
		public Pair(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.r != o.r) return (this.r<o.r)? -1 : 1;
			else return (this.c<o.c)? -1 : 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		sharkSize = 2;
		map = new int[N][N];
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) shark = new Pair(i, j, 0);
			}
		}
		
		ans = 0;
		move();
		System.out.println(ans);
	}

	private static void move() {
		while(true) {
			find = false;
			BFS(shark.r, shark.c);
			if(!find) break;
			else {
				Pair temp = fishes.poll();
				map[shark.r][shark.c] = 0;
				ans += temp.dist;
				shark = new Pair(temp.r, temp.c, 0);
				if(sharkSize == ++eatCnt) {
					eatCnt = 0;
					sharkSize += 1;
				}
			}
		}
	}

	private static void BFS(int r, int c) {
		visited = new boolean[N][N];
		queue = new ArrayDeque<Pair>();
		fishes = new PriorityQueue<Pair>();
		visited[r][c] = true;
		queue.offer(shark);
		
		int eatableDist = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Pair temp = queue.poll();
			if(temp.dist == eatableDist) break;
			for(int d = 0 ; d<4 ; d++) {
				int nr = temp.r+dr[d];
				int nc = temp.c+dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if(map[nr][nc] <= sharkSize) {
						queue.offer(new Pair(nr, nc, temp.dist+1));
						// 먹을 수 있다
						if(map[nr][nc] != 0 && map[nr][nc]<sharkSize) {
							if(!find) {
								find = true;
								eatableDist = temp.dist+1;
							}
							fishes.offer(new Pair(nr,  nc, temp.dist+1));
						}
					}
				}
			}
		}
	}
}
