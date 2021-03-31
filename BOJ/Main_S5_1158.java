package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S5_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] answer = new int[N];
		for(int i = 1 ; i<=N ; i++) {
			queue.offer(i);
		}
		int j = 0;
		while(!queue.isEmpty()) {
			for(int i = 1 ; i<K ; i++) {
				queue.offer(queue.poll());
			}
			answer[j++] = queue.poll();
		}
		System.out.print("<");
		for(int i = 0 ; i<answer.length-1 ; i++) {
			System.out.print(answer[i] + ", ");
		}
		System.out.println(answer[answer.length-1] + ">");
		
	}

}
