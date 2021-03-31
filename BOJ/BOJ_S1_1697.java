package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1697 {
	static int N, K;
	static int[] dr = {-1, 1, 2};
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		BFS();
	}

	private static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		visited[N] = 0;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			if(temp == K) {
				System.out.println(visited[temp]);
				break;
			}
			for(int d = 0 ; d<3 ; d++) {
				int nr = 0;
				if(d != 2) nr = temp+dr[d];
				else nr = temp*dr[d];
				if(nr>-1 && nr<100001 && visited[nr]>visited[temp]+1) {
					visited[nr] = visited[temp]+1;
					queue.offer(nr);
				}
			}
		}
	}
	

}
