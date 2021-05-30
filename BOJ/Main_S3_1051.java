package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_1051 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int W = Math.min(N, M);
		int[][] map = new int[N][M];
		int ans = 1;
		for(int n = 0 ; n<N ; n++) {
			String line = br.readLine();
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = line.charAt(m)-'0';
			}
		}
		for(int n = 0 ; n<N-1 ; n++) {
			for(int m = 0 ; m<M-1 ; m++) {
				for(int w = 1 ; w<W ; w++) {
					if((n+w)>=N || (m+w)>=M) break;
					if(map[n][m] == map[n+w][m] && map[n][m] == map[n][m+w] && map[n][m] == map[n+w][m+w]) {
						ans = Math.max(ans, (w+1)*(w+1));
					}
				}
			}
		}
		System.out.println(ans);
		
	}
}
