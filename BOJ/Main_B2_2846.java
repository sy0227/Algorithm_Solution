package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_2846 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		int ans = 0, sum = 0;;
		for(int n = 0 ; n<N-1 ; n++) {
			if(arr[n]<arr[n+1]) {
				sum += arr[n+1]-arr[n];
				ans = Math.max(ans, sum);
			}
			else sum = 0;
		}
		System.out.println(ans);
	}

}
