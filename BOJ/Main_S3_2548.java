package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_2548 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
		for(int n = 0 ; n<N ; n++) {
			int num = Integer.parseInt(st.nextToken());
			left = Math.min(left, num);
			right = Math.max(right, num);
			arr[n] = num;
		}
		Arrays.sort(arr);
		
		int answer = -1, answer_sum = Integer.MAX_VALUE;
		for(int i = left ; i<=right ; i++) {
			int n = i, sum = 0;
			for(int j = 0 ; j<arr.length ; j++) {
				sum += Math.abs(arr[j]-n);
			}
			if(sum<answer_sum) {
				answer_sum = sum;
				answer = n;
			}
		}
		System.out.println(answer);
	}
}
