package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G5_17070 {
	static int N;
	static int[][] map;
	static Queue<Pos> queue;
	static int[] dr = {0, 1, 1}; // 가로, 대각선, 세로
	static int[] dc = {1, 1, 0};
	
	static class Pos {
		int x;
		int y;
		int dir;
		public Pos(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i<N ; i++) {
			String line = br.readLine();
			for(int j = 0, k = 0 ; j<N ; j++, k+=2) {
				map[i][j] = line.charAt(k)-'0';
			}
		}
		BFS();
	}

	private static void BFS() {
		queue = new LinkedList<Pos>();
		queue.offer(new Pos(0, 1, 0));
		int ans = 0;
		while(!queue.isEmpty()) {
			Pos temp = queue.poll();
			if(temp.x == N-1 && temp.y == N-1) {
				ans++;
				continue;
			}
			
			move(temp.x, temp.y, 1);
			switch (temp.dir) {
			case 0:
				move(temp.x, temp.y, 0);
				break;
			case 1:
				move(temp.x, temp.y, 0);
				move(temp.x, temp.y, 2);
				break;
			case 2:
				move(temp.x, temp.y, 2);
				break;
			default:
				break;
			}
		}
		System.out.println(ans);
	}

	private static void move(int r, int c, int dir) {
		int nr = r+dr[dir];
		int nc = c+dc[dir];
		if(nr<N && nc<N && map[nr][nc] == 0) {
			if(dir == 1) {
				if(map[r+1][c] == 0 && map[r][c+1] == 0) {
					queue.offer(new Pos(nr, nc, dir));
				}
			}
			else {
				queue.offer(new Pos(nr, nc, dir));
			}
		}
	}

}
