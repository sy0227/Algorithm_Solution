package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S4_9372 {
	static int N, M;
	static boolean[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test = 0 ; test<T ; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new boolean[N+1][N+1];
			visited = new boolean[N+1];
			for(int m = 0 ; m<M ; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = true;
				arr[b][a] = true;
			}
			System.out.println(BFS());
		}
	}

	private static int BFS() {
		int ans = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			ans++;
			int node = queue.poll();
			for(int n = 1 ; n<=N ; n++) {
				if(arr[node][n] && !visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return ans-1;
	}

}
