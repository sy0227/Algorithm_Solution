package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_17503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] data = new int[K][2];
		boolean[] checked = new boolean[K];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = Integer.MAX_VALUE;
		for(int k = 0 ; k<K ; k++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			data[k][0] = v;
			data[k][1] = c;
		}
		Arrays.sort(data, ((o1, o2) -> {
			if(o1[1] == o2[1]) return Integer.compare(o2[0], o1[0]);
			else return Integer.compare(o1[1], o2[1]);
		}));
		
		long temp = 0;
		boolean flag = false;
		for(int k = 0 ; k<K ; k++) {
			pq.add(data[k][0]);
			temp += data[k][0];
			if(pq.size()>N) temp -= pq.poll();
			if(pq.size() == N && temp>=M) {
				flag = true;
				System.out.println(data[k][1]);
				break;
			}
		}
		if(!flag) System.out.println("-1");
	}

}
