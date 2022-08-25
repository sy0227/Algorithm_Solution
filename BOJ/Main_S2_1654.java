package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		long right = 0;
		for(int k = 0 ; k<K ; k++) {
			arr[k] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[k]);
		}
		right++;
		
		long left = 0, mid = 0;
		while(left < right) {
			mid = (left+right)/2;
			long sum = 0;
			for(int k = 0 ; k<K ; k++) {
				sum += arr[k]/mid;
			}
			if(sum>=N) left = mid+1;
			else right = mid;
		}
		System.out.println(left-1);
	}
}
