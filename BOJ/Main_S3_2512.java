package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_2512 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int left = 0, right = arr[N-1];
		int M = Integer.parseInt(br.readLine());
		while(left<=right) {
			int mid = (left+right)/2;
			long budget = 0;
			for(int n = 0 ; n<N ; n++) {
				if(arr[n]>mid) budget += mid;
				else budget += arr[n];
			}
			if(budget<=M) left = mid+1;
			else right = mid-1;
		}
		System.out.println(right);
	}
}
