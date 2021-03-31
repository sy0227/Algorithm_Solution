package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2567_배수연 {
	static int[][] map = new int[101][101];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i = x ; i<x+10 ; i++) {
				for(int j = y ; j<y+10 ; j++) {
					map[i][j] = 1;
				}
			}
		}
		for(int i = 1 ; i<101 ; i++) {
			for(int j = 1 ; j<101 ; j++) {
				if(map[i][j] == 1) {
					int nr = 0, nc = 0;
					for(int d = 0 ; d<4 ; d++) {
						nr = i+dr[d];
						nc = j+dc[d];
						if(map[nr][nc] != 1) ans++;
					}
					
				}
			}
		}
		System.out.println(ans);
	}

}
