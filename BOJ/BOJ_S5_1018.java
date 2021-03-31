package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_1018 {
	static int N, M;
	static char[][] map;
	static char[][] white_chess = {
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};
	static char[][] black_chess = {
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int min = 64;
		for(int i = 0 ; i<N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j<M ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i = 0 ; i<=N-8 ; i++) {
			for(int j = 0 ; j<=M-8 ; j++) {
				int white_cnt = 0;
				int black_cnt = 0;
				for(int x = i ; x<i+8 ; x++) {
					for(int y = j ; y<j+8 ; y++) {
						if(map[x][y] != white_chess[x-i][y-j]) white_cnt++;
						if(map[x][y] != black_chess[x-i][y-j]) black_cnt++;
					}
				}
				int temp_min = Math.min(white_cnt, black_cnt);
				min = Math.min(min, temp_min);
				
			}
		}
		System.out.println(min);
	}
}
