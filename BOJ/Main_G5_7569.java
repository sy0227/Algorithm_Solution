package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_7569 {
	static class tomato{
		int r, c, z;
		public tomato(int z, int r, int c) {
			this.z = z;
			this.r = r;
			this.c = c;
		}
	}
	
	static int H, M, N; // 높이, 가로, 세로
	static int[] dr = {-1, 0, 1, 0, 0, 0}; // 상하좌우위아래
	static int[] dc = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int[][][] box;
	static Queue<tomato> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		queue = new LinkedList<>();
		for(int h = 0 ; h<H ; h++) {
			for(int n = 0 ; n<N ; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m = 0 ; m<M ; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					if(box[h][n][m] == 1) queue.add(new tomato(h, n, m));
				}
			}
		}
		BFS();
		System.out.println(getAns());
	}

	private static void BFS() {
		while(!queue.isEmpty()) {
			tomato cur = queue.poll();
			int z = cur.z, r = cur.r, c = cur.c;
			for(int i = 0 ; i<6 ; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				int nz = z+dz[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && nz>=0 && nz<H && box[nz][nr][nc] == 0) {
					queue.add(new tomato(nz, nr, nc));
					box[nz][nr][nc] = box[z][r][c]+1;
				}
			}
		}
	}
	
	private static int getAns() {
		int ans = Integer.MIN_VALUE;
		for(int h = 0 ; h<H ; h++) {
			for(int n = 0 ; n<N ; n++) {
				for(int m = 0 ; m<M ; m++) {
					if(box[h][n][m] == 0) return -1;
					ans = Math.max(ans, box[h][n][m]);
				}
			}
		}
		if(ans == 1) return 0;
		else return ans-1;
	}
}
