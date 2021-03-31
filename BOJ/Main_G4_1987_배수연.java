package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1987_배수연 {
	static int R, C, max;
	static char[][] alphabet;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = new char[R][C];
		max = 0;
		for(int r = 0 ; r<R ; r++) {
			String str = br.readLine();
			for(int c = 0;c<C ; c++) {
				alphabet[r][c] = str.charAt(c);
			}
		}
		// 맨 첫 좌표(좌상단)는 무조건 true
		visited[alphabet[0][0]-'A'] = true;
		move(0, 0, 1);
		System.out.println(max);
	}
	public static void move(int r, int c, int cnt) {
		int nr = 0, nc = 0;
		for(int i = 0 ; i<4 ; i++) {
			nr = r+dr[i];
			nc = c+dc[i];
			if(nr>-1 && nr<R && nc>-1 && nc<C) {
				// 해당 알파벳을 방문한 적 없으면 방문하고 false로 다시 바꿔줌
				if(!visited[alphabet[nr][nc]-'A']) {
					visited[alphabet[nr][nc]-'A'] = true;
					move(nr, nc, cnt+1);
					visited[alphabet[nr][nc]-'A'] = false;
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
