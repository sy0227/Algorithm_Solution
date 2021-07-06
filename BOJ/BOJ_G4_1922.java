package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 네트워크 연결 - MST, Kruskal
 * 비용 기준 오름차순 정렬, union해가면서 비용 더하기
 */

public class BOJ_G4_1922 {
	static int[] parents;
	
	static class Edge implements Comparable<Edge> {
		int from, to, cost;
		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) parents[rootB] = rootA;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Edge> list = new ArrayList<Edge>();
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list.add(new Edge(A, B, C));
		}
		Collections.sort(list);
		
		parents = new int[N+1];
		for(int n = 0 ; n<=N ; n++) {
			parents[n] = n;
		}
		
		int ans = 0;
		for(Edge tempEdge : list) {
			if(find(tempEdge.from) != find(tempEdge.to)) {
				union(tempEdge.from, tempEdge.to);
				ans += tempEdge.cost;
			}
		}
		System.out.println(ans);
	}
}
