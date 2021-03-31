package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_배수연 {
	static int N, M, V;
	static boolean[][] nodes;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		nodes = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodes[from][to] = nodes[to][from] = true;
		}
		DFS(V);
		System.out.println();
		Arrays.fill(visited, false);
		BFS(V);
		
	}
	private static void DFS(int node) {
		visited[node] = true;
		System.out.print(node+" ");
		for(int i = 1 ; i<N+1 ; i++) {
			if(nodes[node][i] && !visited[i]) {
				DFS(i);
			}
		}
	}
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);
		visited[node] = true;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp+" ");
			for(int i = 1 ; i<N+1 ; i++) {
				if(nodes[temp][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
