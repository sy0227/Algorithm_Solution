package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기
 * 1 9 10
 * 10 10 10 -> 30
 * 1 19 19 -> 39
 * 11 11 9 -> 31
 * 
 * 1 2 3 4 5 : 3
 * 3 3 4 5 : 6
 * 4 5 6 : 9
 * 6 9: 15
 * 
 * => 작은것부터 더하고 더한 값이랑 아직 안더한 애들이랑 비교해서 또 작은 애들부터 더하기 => PriorityQueue 이용!
 */

public class BOJ_G4_1715 {
	static class Num implements Comparable<Num>{
		int number;
		public Num(int number) {
			super();
			this.number = number;
		}
		@Override
		public int compareTo(Num o) {
			return this.number-o.number;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Num> pq = new PriorityQueue<Num>();
		for(int n = 0 ; n<N ; n++) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(new Num(num));
		}
		long ans = 0;
		while(pq.size()>1) {
			int one = pq.poll().number;
			int two = pq.poll().number;
			int sum = one+two;
			ans += sum;
			pq.offer(new Num(sum));
		}
		System.out.println(ans);
	}
}
