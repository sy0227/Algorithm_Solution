package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_17610 {
	static int K, S;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		arr = new int[K];
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = 0;
		for(int k = 0 ; k<K ; k++) {
			arr[k] = Integer.parseInt(st.nextToken());
			S += arr[k];
		}
		visited = new boolean[S+1];
		func(0, 0);
		
		int ans = 0;
		for(int s = 1 ; s<=S ; s++) {
			if(!visited[s]) ans++;
		}
		System.out.println(ans);
	}

	private static void func(int idx, int weight) {
		if(idx == K) {
			if(weight>0) visited[weight] = true;
			return;
		}
		func(idx+1, weight);
		func(idx+1, weight+arr[idx]);
		func(idx+1, weight-arr[idx]);
	}

}
