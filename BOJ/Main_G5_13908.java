package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_13908 {
	static int N, M, ans;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[10];
		st = new StringTokenizer(br.readLine());
		for(int m = 0 ; m<M ; m++) {
			int num = Integer.parseInt(st.nextToken());
			visited[num] = true;
		}
		func(0, 0);
		System.out.println(ans);
	}

	private static void func(int idx, int cnt) {
		if(idx == N) {
			if(cnt == M) ans++;
			return;
		}
		for(int i = 0 ; i<=9 ; i++) {
			if(visited[i]) {
				visited[i] = false;
				func(idx+1, cnt+1);
				visited[i] = true;
			}
			else func(idx+1, cnt);
			
		}
	}

}
