package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G5_15686 {
	static int N, M, ans;
	static int[][] map;
	static boolean[] visited;
	static List<int[]> chicken, home;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chicken = new LinkedList<int[]>();
		home = new LinkedList<int[]>();
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) home.add(new int[] {i, j});
				else if(map[i][j] == 2) chicken.add(new int[] {i, j});
			}
		}
		ans = Integer.MAX_VALUE;
		visited = new boolean[chicken.size()];
		DFS(0, 0);
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		System.out.println(sb);
	}

	private static void DFS(int idx, int cnt) {
		if(cnt == M) {
			int total = 0;
			for(int i = 0 ; i<home.size() ; i++) {
				int temp = Integer.MAX_VALUE;
				for(int j = 0 ; j<chicken.size() ; j++) {
					if(visited[j]) {
						int distance = Math.abs(home.get(i)[0]-chicken.get(j)[0])+Math.abs(home.get(i)[1]-chicken.get(j)[1]);
						temp = Math.min(temp, distance);
					}
				}
				total += temp;
			}
			ans = Math.min(ans, total);
			return;
		}
		for(int i = idx ; i<chicken.size() ; i++) {
			visited[i] = true;
			DFS(i+1, cnt+1);
			visited[i] = false;
		}
	}

}
