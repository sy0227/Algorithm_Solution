package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_G3_2533 {
	static int N;
	static int[][] DP;
	static LinkedList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		DP = new int[N+1][2];
		list = new LinkedList[N+1];
		visited = new boolean[N+1];
		
		for(int n = 1 ; n<=N ; n++) {
			list[n] = new LinkedList<Integer>();
		}
		
		for(int n = 0 ; n<N-1 ; n++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].offer(v);
			list[v].offer(u);
		}
		
		func(1, -1);
		System.out.println(Math.min(DP[1][0], DP[1][1]));
	}

	private static void func(int cur, int parent) {
		DP[cur][0] = 0;
		DP[cur][1] = 1;
		for(int i = 0 ; i<list[cur].size() ; i++) {
			int next = list[cur].get(i);
			if(next != parent) {
				func(next, cur);
				DP[cur][0] += DP[next][1];
				DP[cur][1] += Math.min(DP[next][0], DP[next][1]);
			}
		}
	}

}
