package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_2606 {
	static int[][] nodes;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		nodes = new int[C+1][C+1];
		visited = new int[C+1];
		for(int n = 0 ; n<N ; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a][b] = 1;
			nodes[b][a] = 1;
		}
//		BFS(1);
		DFS(1);		
		int cnt = 0;
		for(int i = 0 ; i<visited.length ; i++) {
			cnt += visited[i];
		}
		System.out.println(cnt-1);
	}
	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		visited[v] = 1;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i = 1 ; i<nodes.length ; i++) {
				if(nodes[temp][i] == 1 && visited[i] == 0) {
					queue.offer(i);
					visited[i] = 1;
				}
			}
		}
	}
	private static void DFS(int v) {
		if(visited[v] == 1) {
			return;
		}
		visited[v] = 1;
		for(int i = 1 ; i<nodes.length ; i++) {
			if(nodes[v][i] == 1) DFS(i);
		}
	}

}
