package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_2559_배수연 {
	static int N, K;
	static int[] temperature;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		temperature = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			temperature[n] = Integer.parseInt(st.nextToken());
		}
		int[] sumarr = new int[N-K+1];
		for(int i = 0, k = 0 ; i<N-K+1 ; i++) {
			int sum = 0;
			for(int j = i ; j<i+K ; j++) {
				sum += temperature[j];
			}
			sumarr[k++] = sum;
		}
		Arrays.sort(sumarr);
		System.out.println(sumarr[sumarr.length-1]);
	}

}
