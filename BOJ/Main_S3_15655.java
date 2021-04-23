package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_15655 {
	static int N, M;
	static int[] arr, numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		numbers = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		comb(0, 0);
	}

	private static void comb(int idx, int start) {
		if(idx == M) {
			for (int i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start ; i<N ; i++) {
			numbers[idx] = arr[i];
			comb(idx+1, i+1);
		}
	}

}
