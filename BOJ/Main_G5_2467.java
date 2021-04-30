package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_2467 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int min = Integer.MAX_VALUE;
		int one = Integer.MIN_VALUE, two = Integer.MIN_VALUE;
		for(int n = 0 ; n<N ; n++) {
			int left = n+1;
			int right = N-1;
			while(left<=right) {
				int mid = (left+right)/2;
				int temp = arr[n]+arr[mid];
				if(min>Math.abs(temp)) {
					min = Math.abs(temp);
					one = arr[n];
					two = arr[mid];
				}
				if(temp<0) left = mid+1;
				else right = mid-1;
			}
		}
		System.out.println(one+" "+two);
	}

}
