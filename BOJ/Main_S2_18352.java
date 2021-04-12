package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_18352 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken())-1;
		
		int[] distance = new int[N];
		Arrays.fill(distance, -1);
		distance[X] = 0;
		
		List<Integer>[] list = new ArrayList[N];
		for(int n = 0 ; n<N ; n++) {
			list[n] = new ArrayList<Integer>();
		}
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			list[from].add(to);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(X);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i = 0 ; i<list[temp].size() ; i++) {
				int next = list[temp].get(i);
				if(distance[next] == -1) {
					distance[next] = distance[temp]+1;
					queue.offer(next);
				}
			}
		}
		
		List<Integer> answer = new LinkedList<Integer>();
		for(int n = 0 ; n<N ; n++) {
			if(distance[n] == K) {
				answer.add(n+1);
			}
		}
		if(answer.isEmpty()) System.out.println("-1");
		else {
			Collections.sort(answer);
			for (Integer ans : answer) {
				System.out.println(ans);
			}
		}
	}

}
