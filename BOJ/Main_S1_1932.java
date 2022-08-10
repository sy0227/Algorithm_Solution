package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] DP = new int[N+1][N+1];
		int[][] arr = new int[N+1][N+1];
		for(int i = 1 ; i<=N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j<=i ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1 ; i<=N ; i++) {
			for(int j = 1 ; j<=N ; j++) {
				DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + arr[i][j];
			}
		}
		int answer = 0;
		for(int i = 1 ; i<=N ; i++) {
			answer = Math.max(answer, DP[N][i]);
		}
		System.out.println(answer);
	}

}
