package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S1_2447 {
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0 ; i<N ; i++) {
			Arrays.fill(map[i], ' ');
		}
		
		draw(0, 0, N);
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static void draw(int r, int c, int idx) {
		if(idx == 1) {
			map[r][c] = '*';
			return;
		}
		for(int i = 0 ; i<3 ; i++) {
			for(int j = 0 ; j<3 ; j++) {
				if(i == 1 && j == 1) continue;
				else draw(r+i*idx/3, c+j*idx/3, idx/3);
			}
		}
	}
}
