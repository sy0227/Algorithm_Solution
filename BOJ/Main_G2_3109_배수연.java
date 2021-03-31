package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1. 파이프를 놓는 순서
 * 	- 가능한 위쪽으로 파이프를 놔야 아래쪽에 더 많은 파이프를 놓을 수 있으므로, 우상, 우, 우하 순으로 시도해봐야 한다.
 * 
 * 2. 수행횟수
 * 	- 한 행 첫 열 시도 3^C * R (중간 건물, 기존 파이프라인로 가지치기하면 시간을 줄여줌)
 * 		2.1 가지치기
 * 			- 파이프 놓기에 성공했다면 시작열로 계속해서 돌아간다.
 * 			- 이전 파이프 놓기에 실패한 흔적을 남겨둔다 => 남겨두지 않으면 같은 실수를 반복하게 됨
 */
public class Main_G2_3109_배수연 {
	static int R, C, cnt = 0;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];
		for(int r = 0 ; r<R ; r++) {
			map[r] = br.readLine().toCharArray();
		}
		setPipes();
		System.out.println(cnt);
	}
	public static void setPipes() {
		cnt = 0;
		// 윗 행부터 시도
		for(int i = 0 ; i<R ; i++) {
			visited[i][0] = true;
			dfs(i, 0);
		}
	}
	public static boolean dfs(int r, int c) {
		if(c == C-1) {
			cnt++;
			return true; // 파이프 놓기 성공
		}
		int nr, nc = c+1;
		for(int d = 0 ; d<3 ; d++) {
			nr = r+dr[d];
			if(nr<0 || nr>=R || map[nr][nc] == 'x' || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(dfs(nr, nc)) return true; // 끝까지 갔다 왔는데 파이프 놓을 수 있다고 판단된 경우 => 이제 앞으로 백트래킹 해야 한다.
//			visited[nr][nc] = false; // 실패했던 흔적을 되돌리면 안됨 => 뒤 선택지의 방향은 현재보다 유리하지 않은 상황이고, 결국 같은 상황이 되풀이됨.
		}
		return false;
	}
}
