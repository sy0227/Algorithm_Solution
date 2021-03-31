package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1912 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 1 ; n<=N ; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int n = 1 ; n<=N ; n++) {
			num[n] = Math.max(num[n], num[n]+num[n-1]);
			max = Math.max(max, num[n]);
		}
		System.out.println(max);
	}

}
