package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_14889 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int sumA, sumB, result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		for(int i = 0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(result);
	}
	public static void comb(int idx, int start) {
		if(idx == N/2) {
			sumA = 0;
			sumB = 0;
			for(int i = 0 ; i<N-1 ; i++) {
				for(int j = i+1 ; j<N ; j++) {
					if(visited[i] && visited[j]) {
						sumA += map[i][j];
						sumA += map[j][i];
					}
					else if(!visited[i] && !visited[j]) {
						sumB += map[i][j];
						sumB += map[j][i];
					}
				}
			}
			result = Math.min(result, Math.abs(sumA-sumB));
			return;
		}
		for(int i = start ; i<N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(idx+1, i+1);
				visited[i] = false;
			}
		}
	}

}
