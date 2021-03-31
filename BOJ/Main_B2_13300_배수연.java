package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 학년 별, 성별 별 인원%K == 0이면 ans+= 인원/K
 * 나머지가 1 이상이면 ans += 인원/K+1
 */
public class Main_B2_13300_배수연 {
	static int N, K;
	static int[][] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		students = new int[7][2];
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			students[grade][gender]++;
		}
		int ans = 0;
		for(int r = 1 ; r<7 ; r++) {
			for(int c = 0 ; c<=1 ; c++) {
				if(students[r][c]%K == 0) ans += students[r][c]/K;
				else ans += students[r][c]/K+1;
			}
		}
		System.out.println(ans);
	}

}
