package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_G3_20666 {
	static class Tip{
		int a;
		int b;
		int t;
		public Tip(int a, int b, int t) {
			super();
			this.a = a;
			this.b = b;
			this.t = t;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Tip [a=").append(a).append(", b=").append(b).append(", t=").append(t).append("]");
			return builder.toString();
		}
		
	}
	static int N, M, P;
	static PriorityQueue<Integer> pq;
	static Tip[] tip;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		P = Integer.parseInt(br.readLine());
		if(P > 0) {
			tip = new Tip[P];
			for(int p = 0 ; p<P ; p++) {
				st = new StringTokenizer(br.readLine());
				int p_a = Integer.parseInt(st.nextToken());
				int p_b = Integer.parseInt(st.nextToken());
				int p_t = Integer.parseInt(st.nextToken());
				tip[p] = new Tip(p_a, p_b, p_t);
//				System.out.println(tip[p]);
			}
		func();
		}
		else {
			for(int i = 0 ; i<M-1 ; i++) {
				pq.poll();
			}
			System.out.println(pq.poll());
			return;
		}
	}

	private static void func() {
		for(int i = 0 ; i<tip.length ; i++) {
			System.out.println(tip[i]);
		}
	}

}
