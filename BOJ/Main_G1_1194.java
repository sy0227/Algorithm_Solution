package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_G1_1194 {
	static int N, M, from_x, from_y, ans;
	static char[][] map;
	static boolean[][][] visited; // r, c, key(bit)
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visited = new boolean[N][M][1<<6];
		// 입력받으면서 출발 위치 저장해두기
		for(int n = 0 ; n<N ; n++) {
			String line = sc.next();
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = line.toCharArray()[m];
				if(map[n][m] == '0') {
					from_x = n;
					from_y = m;
				}
			}
		}
		BFS();
		System.out.println(ans);
	}

	private static void BFS() {
		ans = -1;
		Queue<int[]> queue = new LinkedList<int[]>();
		// queue에 처음 위치 저장하고 반복 시작
		queue.offer(new int[] {from_x, from_y, 0, 0});
		visited[from_x][from_y][0] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			int temp_key = temp[2];
			int temp_cnt = temp[3];
			
			// 도착지 1이 어디에 있든지 만나면 바로 리턴
			if(map[temp_x][temp_y] == '1') {
				ans = temp_cnt;
				return;
			}
			
			int nr = 0, nc = 0;
			for(int d = 0 ; d<4 ; d++) {
				nr = temp_x+dr[d];
				nc = temp_y+dc[d];
				if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] != '#') {
					// 열쇠 얻으면 visited에 비트로 표시
					if(map[nr][nc]>=97 && map[nr][nc]<=102) {
						int key = temp_key | (1<<(map[nr][nc]-'a'));
						if(!visited[nr][nc][key]) {
							queue.offer(new int[] {nr, nc, key, temp_cnt+1});
							visited[nr][nc][key] = true;
						}
					}
					// 문을 만나면 해당 key bit의 visited 배열 확인
					else if(map[nr][nc]>=65 && map[nr][nc]<=70) {
						int key = temp_key & (1<<(map[nr][nc]-'A'));
						if(key != 0 && !visited[nr][nc][temp_key]) {
							queue.offer(new int[] {nr, nc, temp_key, temp_cnt+1});
							visited[nr][nc][temp_key] = true;
						}
					}
					// 빈 곳인 경우는 방문체크만 하면서 반복
					else {
						if(!visited[nr][nc][temp_key]) {
							queue.offer(new int[] {nr, nc, temp_key, temp_cnt+1});
							visited[nr][nc][temp_key] = true;
						}
					}
				}
			}
		}
	}
}
