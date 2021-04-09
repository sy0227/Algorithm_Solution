package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S3_1448 {
	// 삼각형 만족 : 가장 긴 변이 a일 때 a<b+c를 만족해야 한다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tri = new int[N];
		int max = 0;
		for(int n = 0 ; n<N ; n++) {
			tri[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(tri);
		for(int i = N-1 ; i>=2 ; i--) {
			int a = tri[i];
			int b = tri[i-1];
			int c = tri[i-2];
			if(a<b+c) max = Integer.max(max, a+b+c);
		}
		System.out.println((max == 0)? "-1" : max);
	}

}
