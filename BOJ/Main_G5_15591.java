package boj;

import java.io.*;
import java.util.*;

public class Main_G5_15591 {
	static int N, Q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		List<int[]>[] list = new ArrayList[N+1];
		
		for(int n = 1 ; n<=N ; n++) {
			list[n] = new ArrayList<int[]>();
		}
		
		for(int n = 0 ; n<N-1 ; n++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			list[p].add(new int[] {q, r});
			list[q].add(new int[] {p, r});
		}
		
		for(int q = 0 ; q<Q ; q++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[N+1];
			int ans = 0;
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(v);
			visited[v] = true;
			while(!queue.isEmpty()) {
				int temp = queue.poll();
				for (int[] arr : list[temp]) {
					if(!visited[arr[0]] && arr[1] >= k) {
						queue.offer(arr[0]);
						visited[arr[0]] = true;
						ans++;
					}
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb.toString());
	}

}
