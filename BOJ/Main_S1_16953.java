package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_S1_16953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		Queue<long[]> queue = new LinkedList<long[]>();
		queue.offer(new long[] {A, 0});
		while(!queue.isEmpty()) {
			long[] temp = queue.poll();
			long temp_val = temp[0];
			long temp_cnt = temp[1];
			if(temp_val == B) {
				System.out.println(temp_cnt+1);
				return;
			}
			else if(temp_val>B) continue;
			
			queue.offer(new long[] {temp_val*2, temp_cnt+1});
			queue.offer(new long[] {temp_val*10+1, temp_cnt+1});
		}
		System.out.println("-1");
	}

}
