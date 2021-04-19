package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S4_12789 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for(int n = 1 ; n<=N ; n++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		int idx = 1;
		while(!queue.isEmpty()) {
			int num = queue.peek();
			if(num == idx) {
				idx++;
				queue.poll();
			}
			else {
				if(!stack.empty() && stack.peek() == idx) {
					stack.pop();
					idx++;
				}
				else {
					stack.push(num);
					queue.poll();
				}
			}
		}
		while(!stack.isEmpty()) {
			int num = stack.peek();
			stack.pop();
			if(num != idx) {
				System.out.println("Sad");
				return;
			}
			idx++;
		}
		System.out.println("Nice");
	}

}
