package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2491_배수연 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int less_len = 1;
		int large_len = 1;
		int max_len = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			numbers[n] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i<N-1 ; i++) {
			if(numbers[i]<=numbers[i+1]) large_len++;
			else large_len = 1;
			max_len = Math.max(max_len, large_len);
		}
		for(int i = 0 ; i<N-1 ; i++) {
			if(numbers[i]>=numbers[i+1]) less_len++;
			else less_len = 1;
			max_len = Math.max(max_len, less_len);
		}
		System.out.println(max_len);
	}
}
