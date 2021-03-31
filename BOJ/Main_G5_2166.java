package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_2166 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		long[] x = new long[N+1];
		long[] y = new long[N+1];
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			x[n] = Integer.parseInt(st.nextToken());
			y[n] = Integer.parseInt(st.nextToken());
		}
		
		x[N] = x[0];
		y[N] = y[0];
		
		long op1 = 0;
		long op2 = 0;
		for(int n = 0 ; n<N ; n++) {
			op1 += x[n]*y[n+1];
			op2 += x[n+1]*y[n];
		}
		String result = String.format("%.1f", (Math.abs(op1-op2)/2.0));
		System.out.println(result);
	}

}
