package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1197 {
	static class Node implements Comparable<Node>{
		int idx;
		long val;
		public Node(int idx, long val) {
			super();
			this.idx = idx;
			this.val = val;
		}
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.val, o.val);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Node>[] list = new ArrayList[V];
		for(int v = 0 ; v<V ; v++) {
			list[v] = new ArrayList<Node>();
		}
		boolean[] visited = new boolean[V];
		for(int e = 0 ; e<E ; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			int C = Integer.parseInt(st.nextToken());
			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
		}
		
		int result = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.offer(0);
		while(!dq.isEmpty()) {
			int curr_idx = dq.poll();
			visited[curr_idx] = true;
			for (Node temp : list[curr_idx]) {
				int next_idx = temp.idx;
				long next_val = temp.val;
				if(!visited[next_idx]) pq.offer(new Node(next_idx, next_val));
			}
			
			while(!pq.isEmpty()) {
				Node temp = pq.poll();
				int next_idx = temp.idx;
				long next_val = temp.val;
				if(!visited[next_idx]) {
					visited[next_idx] = true;
					dq.add(next_idx);
					result += next_val;
					break;
				}
			}
		}
		System.out.println(result);
	}

}
/*
3 3
1 2 2
1 3 3
2 3 9999
*/