package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S1_11497 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 0 ; test<T ; test++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0 ; n<N ; n++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			int[] sortedArr = new int[N];
			sortedArr[N/2] = pq.poll();
			int left = N/2-1, right = N/2+1;
			while(!pq.isEmpty()) {
				if(left>=0) sortedArr[left--] =  pq.poll();
				if(right<N) sortedArr[right++] = pq.poll();
			}
			int max = Integer.MIN_VALUE;
			for(int i = 0 ; i<N-1 ; i++) {
				max = Math.max(Math.abs(sortedArr[i+1]-sortedArr[i]), max);
			}
			System.out.println(max);
		}
	}

}
