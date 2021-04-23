package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1182 {
	static int N, S, ans;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			nums[n] = Integer.parseInt(st.nextToken());
		}
		DFS(0, 0);
		if(S == 0) System.out.println(ans-1);
		else System.out.println(ans);
	}

	private static void DFS(int idx, int sum) {
		if(idx == N) {
			if(sum == S) ans++;
			return;
		}
		DFS(idx+1, sum);
		DFS(idx+1, sum+nums[idx]);
	}

}
