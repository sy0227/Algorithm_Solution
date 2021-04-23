package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1868 {
	static int N;
	static char[][] map;
	static int[][] bombCnt;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상하좌우 좌상 우상 우하 좌하
	static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			bombCnt = new int[N][N];
			for(int n = 0 ; n<N ; n++) {
				map[n] = br.readLine().toCharArray();
				Arrays.fill(bombCnt[n], Integer.MIN_VALUE); // 방문하면 -1로 mapping하기 위해 초기값을 min_value로 지정
			}
			
			// 8방에 지뢰가 몇 개 있는지 모든 map에 대해서 저장
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					if(map[i][j] == '.') {
						int bomb = 0;
						for(int d = 0 ; d<8 ; d++) {
							int nr = i+dr[d];
							int nc = j+dc[d];
							if(nr>-1 && nr<N && nc>-1 && nc<N && map[nr][nc] == '*') bomb++;
						}
						bombCnt[i][j] = bomb;
					}
				}
			}
			
			int ans = 0;
			// 주변에 지뢰가 없는 칸부터 BFS 시작
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					if(bombCnt[i][j] == 0) {
						BFS(i, j);
						ans++;
					}
				}
			}
			
			// 아직 클릭하지 않은 곳이 있다면 (주변에 지뢰가 있다는 뜻) 클릭해주기
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					if(bombCnt[i][j]>0) ans++;
				}
			}
			
			System.out.println("#"+test+" "+ans);
		}
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i, j});
		bombCnt[i][j] = -1; // 방문체크
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			for(int d = 0 ; d<8 ; d++) {
				int nr = temp_x+dr[d];
				int nc = temp_y+dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<N) {
					if(bombCnt[nr][nc] == 0) queue.offer(new int[] {nr, nc});
					bombCnt[nr][nc] = -1;
				}
			}
		}
	}

}
