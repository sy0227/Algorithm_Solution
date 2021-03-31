package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_1992 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int n = 0 ; n<N ; n++) {
			String str = br.readLine();
			for(int i = 0 ; i<N ; i++) {
				map[n][i] = str.charAt(i)-'0';
			}
		}
		divide(0, 0, N);
		System.out.println(sb.toString());
	}
	public static void divide(int r, int c, int size) {
		if(equal(r, c, size)) sb.append(map[r][c]);
		else {
			int len = size/2;
			sb.append("(");
			divide(r, c, len);
			divide(r, c+len, len);
			divide(r+len, c, len);
			divide(r+len, c+len, len);
			sb.append(")");
		}
	}
	public static boolean equal(int r, int c, int size) {
		for(int i = r ; i<r+size ; i++) {
			for(int j = c ; j<c+size ; j++) {
				if(map[r][c] != map[i][j]) return false;
			}
		}
		return true;
	}
}
