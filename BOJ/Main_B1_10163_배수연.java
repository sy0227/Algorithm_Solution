package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1_10163_배수연 {
	static int N;
	static int[][] paper;
	static int[][] map = new int[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][4];
		for(int n = 0 ; n<N ; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<4 ; i++) {
				paper[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 0;
		for(int n = 0 ; n<N ; n++) {
			idx++;
			for(int r = paper[n][0] ; r<paper[n][0]+paper[n][2] ; r++) {
				for(int c = paper[n][1] ; c<paper[n][1]+paper[n][3] ; c++) {
					map[r][c] = idx;
				}
			}
		}
		int[] ans = new int[N+1];
		for(int i = 0 ; i<map.length ; i++) {
			for(int j = 0 ; j<map.length ; j++) {
				for(int n = 1 ; n<N+1 ; n++) {
					if(map[i][j] == n) ans[n]++;
				}
			}
		}
		for(int i = 1 ; i<ans.length ; i++) {
			System.out.println(ans[i]);
		}
	}

}
