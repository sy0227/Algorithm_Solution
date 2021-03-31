package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_1449 {
	static int N, L;
	static int[] water;
	static boolean[] closed;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		water = new int[1001];
		closed = new boolean[1001];
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			water[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(water, 0, N);
		
		int cnt = 0;
		int last = -L;
		for(int n = 0 ; n<N ; n++) {
			if(water[n]>=last+L) {
				last = water[n];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
