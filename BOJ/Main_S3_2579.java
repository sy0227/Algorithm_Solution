package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_2579 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N+1];
		int[][] results = new int[N+1][2];
		for(int n = 1 ; n<=N ; n++) {
			num[n] = Integer.parseInt(br.readLine());
		}
		results[1][0] = num[1];
		results[1][1] = 0;
		for(int i = 2 ; i<=N ; i++) {
			results[i][0] = Math.max(results[i-2][0], results[i-2][1])+num[i]; // 한 번 연속해서 온 경우 -> 두 칸 전 값에서 큰 값 가져옴
			results[i][1] = results[i-1][0]+num[i]; // 두 번 연속해서 온 경우 -> 이전 칸 값만 가져옴
		}
		System.out.println(Math.max(results[N][0], results[N][1]));
	}

}
