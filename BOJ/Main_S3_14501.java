package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_14501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] T = new int[N];
		int[] P = new int[N];
		int[] DP = new int[N+1];
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			T[n] = Integer.parseInt(st.nextToken());
			P[n] = Integer.parseInt(st.nextToken());
		}
		for(int n = 0 ; n<N ; n++) {
			if(n+T[n] <= N) DP[n+T[n]] = Math.max(DP[n+T[n]], DP[n]+P[n]);
			DP[n+1] = Math.max(DP[n+1], DP[n]);
		}
		System.out.println(DP[N]);
	}

}
