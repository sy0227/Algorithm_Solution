package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1학년
 * DP
 * N개의 숫자가 주어졌을 때, +, - 연산자를 이용해서 가장 마지막 N번째로 입력되는 수가 나오도록 등식 만들기
 */

public class Main_G5_5557 {
	static int N;
	static long[][] DP;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		DP = new long[N+1][21];
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			numbers[n] = Integer.parseInt(st.nextToken());
		}
		
		DP[0][numbers[0]] = 1;
		for(int i = 1 ; i<N-1 ; i++) {
			for(int j = 0 ; j<=20 ; j++) {
				if(isRange(j+numbers[i])) DP[i][j] += DP[i-1][j+numbers[i]];
				if(isRange(j-numbers[i])) DP[i][j] += DP[i-1][j-numbers[i]];
			}
		}
		System.out.println(DP[N-2][numbers[N-1]]);
	}

	private static boolean isRange(int range) {
		if(range >= 0 && range <=20) return true;
		return false;
	}

}
