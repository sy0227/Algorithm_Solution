package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G5_15683 {
	static int N, M, ans;
	static int[][] map;
	static List<CCTV> list;
	static int[][] tvDir = {
							{}, 
							{0}, 
							{0, 2},
							{0, 1},
							{0, 1, 3},
							{0, 1, 2, 3}
							};
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	
	static class CCTV {
		int x;
		int y;
		int type;
		public CCTV(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		map = new int[N][M];
		list = new LinkedList<CCTV>();
		for(int n = 0 ; n<N ; n++) {
			String line = br.readLine();
			for(int m = 0, k=0 ; m<M ; m++, k+=2) {
				map[n][m] = line.charAt(k)-'0';
				// CCTV의 위치를 List에 저장해두기
				if(map[n][m]>0 && map[n][m]<6) list.add(new CCTV(n, m, map[n][m]));
			}
		}
		checkBlank(0);
		System.out.println(ans);
	}

	private static void checkBlank(int idx) {
		if(idx == list.size()) {
			// 빈 곳 개수 갱신
			int blank = 0;
			for(int n = 0 ; n<N ; n++) {
				for(int m = 0 ; m<M ; m++) {
					if(map[n][m] == 0) blank++;
				}
			}
			ans = Math.min(ans, blank);
			return;
		}
		
		int tv_x = list.get(idx).x;
		int tv_y = list.get(idx).y;
		int tv_dir = list.get(idx).type;
		
		// 반복 돌 때의 map 정보를 저장
		int[][] tempMap = new int[N][M];
		for(int n = 0 ; n<N ; n++) {
			tempMap[n] = Arrays.copyOfRange(map[n], 0, M);
		}
		
		// 회전할 수 있는 모든 경우의 수 따져보기
		int nr = 0, nc = 0;
		for(int d = 0 ; d<4 ; d++) {
			// 반복할 때마다 tempMap으로 초기화
			for(int n = 0 ; n<N ; n++) {
				map[n] = Arrays.copyOfRange(tempMap[n], 0, M);
			}
			
			for(int i = 0 ; i<tvDir[tv_dir].length ; i++) {
				int dir = tvDir[tv_dir][i];
				int nd = (dir+d)%4;
				nr = tv_x+dr[nd];
				nc = tv_y+dc[nd];
				
				// 회전시킨 방향에서 감시 가능한 영역을 -1로 채우기
				while(nr>-1 && nr<N && nc>-1 && nc<M) {
					if(map[nr][nc] == 6) break;
					if(map[nr][nc] == 0) map[nr][nc] = -1;
					nr += dr[nd];
					nc += dc[nd];
				}
			}
			checkBlank(idx+1);
		}
	}
}
