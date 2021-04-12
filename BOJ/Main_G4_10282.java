package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_10282 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			int cntCom = 0, time = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken())-1;
			List<int[]>[] list = new ArrayList[N];
			for(int n = 0 ; n<N ; n++) {
				list[n] = new ArrayList<int[]>();
			}
			
			for(int d = 0 ; d<D ; d++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken())-1;
				int B = Integer.parseInt(st.nextToken())-1;
				int S = Integer.parseInt(st.nextToken());
				list[B].add(new int[] {A, S});
			}
			
			PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
			});
			
			int[] path = new int[N];
			Arrays.fill(path, Integer.MAX_VALUE);
			path[C] = 0;
			queue.offer(new int[] {C, 0});
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				int temp_com = temp[0];
				int temp_time = temp[1];
				for(int i = 0 ; i<list[temp_com].size() ; i++) {
					int[] next = list[temp_com].get(i);
					int next_com = next[0];
					int next_time = next[1];
					if(path[next_com]>temp_time+next_time) {
						path[next_com] = temp_time+next_time;
						queue.offer(new int[] {next_com, path[next_com]});
					}
				}
			}
			
			for(int i = 0 ; i<N ; i++) {
				if(path[i] != Integer.MAX_VALUE) {
					cntCom++;
					time = Math.max(time, path[i]);
				}
			}
			
			System.out.println(cntCom+" "+time);
		}
	}

}
