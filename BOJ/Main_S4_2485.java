package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_2485 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		Integer[] gap = new Integer[N-1];
		
		for(int n = 0 ; n<N ; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int n = 0 ; n<N-1 ; n++) {
			gap[n] = arr[n+1]-arr[n];
		}
		
		int gcd = gap[0];
		for(int n = 1 ; n<N-1 ; n++) {
			gcd = GCD(gap[n], gcd);
		}
		int answer = 0;
		for(int n = 0 ; n<N-1 ; n++) {
			answer += gap[n]/gcd-1;
		}
		System.out.println(answer);
	}

	private static int GCD(int a, int b) {
		if(b == 0) return a;
		return GCD(b, a%b);
	}

}
