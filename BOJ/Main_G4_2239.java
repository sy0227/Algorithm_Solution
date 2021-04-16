package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G4_2239 {
	static int[][] map = new int[9][9];
	static int zero;
	static boolean answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zero = 0;
		for(int i = 0 ; i<9 ; i++) {
			String line = br.readLine();
			for(int j = 0 ; j<9 ; j++) {
				map[i][j] = line.charAt(j)-'0';
				if(map[i][j] == 0) zero++;
			}
		}
		for(int i = 0 ; i<9 ; i++) {
			for(int j = 0 ; j<9 ; j++) {
				if(map[i][j] == 0) DFS(i, j);
			}
		}
	}

	private static void DFS(int r, int c) {
		if(!answer) {
			for(int n = 1 ; n<=9 ; n++) {
				if(check(r, c, n)) {
					map[r][c] = n;
					zero--;
					if(zero == 0) {
						for(int i = 0 ; i<9 ; i++) {
							for(int j = 0 ; j<9 ; j++) {
								System.out.print(map[i][j]);
							}
							System.out.println();
						}
						answer = true;
						return;
					}
					
					top:
						for(int i = 0 ; i<9 ; i++) {
							for(int j = 0 ; j<9 ; j++) {
								if(map[i][j] == 0) {
									DFS(i, j);
									break top;
								}
							}
						}
					
					map[r][c] = 0;
					zero++;
				}
				
			}
			
		}
	}

	private static boolean check(int r, int c, int num) {
		// row
		for(int j = 0 ; j<9 ; j++) {
			if(map[r][j] == num) return false;
		}
		
		// col
		for(int i = 0 ; i<9 ; i++) {
			if(map[i][c] == num) return false;
		}
		
		// square
		int nr = (r/3)*3;
		int nc = (c/3)*3;
		for(int i = nr ; i<nr+3 ; i++) {
			for(int j = nc ; j<nc+3 ; j++) {
				if(map[i][j] == num) return false;
			}
		}
		
		return true;
	}

}
