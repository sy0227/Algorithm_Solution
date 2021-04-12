package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17144 {
	static int R, C, T;
	static int[][] map;
	static int[] airCleaner;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		airCleaner = new int[2];
		for(int r = 0, k = 0 ; r<R ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c<C ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) airCleaner[k++] = r;
			}
		}
		
		// 주어진 시간 T만큼 (확산, 공기청정) 반복
		while(T-- > 0) {
			spreadDust();
			airClean();
		}
		
		// -1인 칸은 공기청정기의 위치이므로 다른 칸들의 먼지 양만 합하기
		int sum = 0;
		for(int r = 0, k = 0 ; r<R ; r++) {
			for(int c = 0 ; c<C ; c++) {
				if(map[r][c] != -1) sum += map[r][c];
			}
		}
		
		System.out.println(sum);
	}

	private static void spreadDust() {
		// 우선 기존에 먼지가 있던 곳 찾기
		Queue<int[]> dust = new LinkedList<int[]>();
		for(int r = 0 ; r<R ; r++) {
			for(int c = 0 ; c<C ; c++) {
				if(map[r][c] > 0) {
					dust.offer(new int[] {r, c, map[r][c]});
				}
			}
		}
		
		// list의 i번째 좌표에서 공기청정기, 범위 밖을 제외하고 퍼질 수 있는 칸에 먼지 퍼트리기
		while(!dust.isEmpty()) {
			int[] temp = dust.poll();
			if(temp[2]<5) continue;
			int spread = temp[2]/5;
			int cnt = 0;
			
			int nr = 0, nc = 0;
			for(int d = 0 ; d<4 ; d++) {
				nr = temp[0]+dr[d];
				nc = temp[1]+dc[d];
				if(nr>-1 && nr<R && nc>-1 && nc<C && map[nr][nc] != -1) {
					// queue에서 poll한 좌표의 먼지 양은 map[r][c]/5
					map[nr][nc] += spread;
					cnt++;
				}
			}
			// 원래 먼지 있던 칸의 먼지 양 = map[r][c]-(map[r][c]/5)*cnt
			map[temp[0]][temp[1]] = map[temp[0]][temp[1]]-spread*cnt;
		}
	}

	private static void airClean() {
		int up = airCleaner[0];
		int down = airCleaner[1];
		
		// 공기청정기 위쪽 칸은 반시계 - 상우하좌로 밀기
		for(int i = up-1 ; i>0 ; i--) {
			map[i][0] = map[i-1][0];
		}
		for(int i = 0 ; i<C-1 ; i++) {
			map[0][i] = map[0][i+1];
		}
		for(int i = 0 ; i<up ; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for(int i = C-1 ; i>1 ; i--) {
			map[up][i] = map[up][i-1];
		}
		map[up][1] = 0;
		
		// 아래 쪽은 시계 - 하우상좌로 밀기
		for(int i = down+1 ; i<R-1 ; i++) {
			map[i][0] = map[i+1][0];
		}
		for(int i = 0 ; i<C-1 ; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		for(int i = R-1 ; i>down ; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for(int i = C-1 ; i>1 ; i--) {
			map[down][i] = map[down][i-1];
		}
		map[down][1] = 0;
	}

}
