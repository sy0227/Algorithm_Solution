package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_13023 {
	static int N, M, ans;
	static boolean[] visited;
	static ArrayList<Integer>[] friends;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friends = new ArrayList[N];
		for(int n = 0 ; n<N ; n++) {
			friends[n] = new ArrayList<Integer>();
		}
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
		
		for(int i = 0 ; i<N ; i++) {
			visited = new boolean[N];
			visited[i] = true;
			DFS(i, 0);
			if(ans == 4) {
				System.out.println("1");
				return;
			}
		}
		System.out.println("0");
	}

	private static void DFS(int num, int cnt) {
		ans = Math.max(ans, cnt);
		if(ans == 4) return;
		for(int i = 0 ; i<friends[num].size() ; i++) {
			int next = friends[num].get(i);
			if(!visited[next]) {
				visited[next] = true;
				DFS(next, cnt+1);
			}
		}
		visited[num] = false;
	}

}
