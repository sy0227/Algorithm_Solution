package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S3_15654 { // nPr
	static int N, M;
	static int[] nums;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		numbers = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			nums[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		perm(0, 0);
	}

	private static void perm(int idx, int flag) {
		if(idx == M) {
			for (int i : numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i = 0 ; i<N ; i++) {
			if((flag&1<<i) == 0) {
				numbers[idx] = nums[i];
				perm(idx+1, flag|1<<i);
			}
		}
	}

}
