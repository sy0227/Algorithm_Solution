package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G2_12763 {
	static int N, T, M, L, ans;
	static ArrayList<Node>[] info;
	static int[] costs, times;
	
	static class Node {
		int destination, time, cost;
		public Node(int destination, int time, int cost) {
			this.destination = destination;
			this.time = time;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(br.readLine());
		
		info = new ArrayList[N+1];
		for(int n = 1 ; n<=N ; n++) {
			info[n] = new ArrayList<>();
		}
		costs = new int[N+1];
		times = new int[N+1];
		
		for(int l = 0 ; l<L ; l++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			info[from].add(new Node(to, time, cost));
			info[to].add(new Node(from, time, cost));
		}
		
		ans = func(1, N);
		if(ans>M) ans = -1;
		System.out.println(ans);
		
	}

	private static int func(int n1, int n2) {
		Arrays.fill(costs, Integer.MAX_VALUE);
		Arrays.fill(times, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost-o2.cost;
			}
		});
		costs[n1] = 0;
		times[n1] = 0;
		
		pq.offer(new Node(n1, 0, 0));
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int temp_dest = temp.destination;
			int temp_time = temp.time;
			int temp_cost = temp.cost;
			
			if(temp_dest == N) return temp_cost;
			for(int i = 0 ; i<info[temp_dest].size() ; i++) {
				int next = info[temp_dest].get(i).destination;
				int next_time = info[temp_dest].get(i).time;
				int next_cost = info[temp_dest].get(i).cost;
				
				if(temp_time+next_time > T) continue;
				if(costs[next]>=temp_cost+next_cost || times[next]>=temp_time+next_time) {
					if(times[next]>temp_time+next_time) times[next] = temp_time+next_time;
					if(costs[next]>temp_cost+next_cost) costs[next] = temp_cost+next_cost;
					pq.add(new Node(next, temp_time+next_time, temp_cost+next_cost));
				}
			}
		}
		return -1;
	}
}
