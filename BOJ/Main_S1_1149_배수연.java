package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1149_배수연 {
	static int N, min;
	static int[][] cost, DP;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		DP = new int[N][3];
		min = Integer.MAX_VALUE;
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<3 ; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int j = 0 ; j<3 ; j++) { // 첫 행은 입력받은 비용을 그대로
			DP[0][j] = cost[0][j];
		}
		for(int i = 1 ; i<N ; i++) {
			for(int j = 0 ; j<3 ; j++) { // 이전에 칠한 색 후보 두개 중 적은 비용으로 칠한 경우의 비용 + 현재 rgb중 한 색으로 칠하는 비용
				// R이면 이전 행의 G, B 중 최소
				// G이면 이전 행의 R, B 증 최소
				// B이면 이전 행의 R, G 중 최소
				DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + cost[i][0];
				DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + cost[i][1];
				DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + cost[i][2];
			}
		}
		for(int j = 0 ; j<3 ; j++) {
			min = Math.min(min, DP[N-1][j]); // 마지막 행에서 최소비용 확인
		}
		System.out.println(min);
	}
}
