package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_2473 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for(int n = 0 ; n<N ; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long minSum = Long.MAX_VALUE;
		int a = 0, b = 0, c = 0;
		for(int first = 0 ; first<N-2 ; first++) {
			int second = first+1, third = N-1;
			while(second<third) {
				long sum = arr[first]+arr[second]+arr[third];
				if(Math.abs(sum)<minSum) {
					minSum = Math.abs(sum);
					a = first;
					b = second;
					c = third;
				}
				if(sum<0) second++;
				else third--;
			}
		}
		System.out.println(arr[a]+" "+arr[b]+" "+arr[c]);
	}

}
