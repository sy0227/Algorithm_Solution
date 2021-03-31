package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S2_2841 {
	static int N, P, L, F;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Stack<Integer>[] stack = new Stack[7];
		int cnt = 0;
		for(int i = 1 ; i<=6 ; i++) {
			stack[i] = new Stack<Integer>();
		}
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());
			
			while(!stack[L].isEmpty() && stack[L].peek() > F) {
				stack[L].pop();
				cnt++;
			}
			if(stack[L].isEmpty() || stack[L].peek() < F) {
				stack[L].push(F);
				cnt++;
			}
			if(stack[L].peek() == F) continue;
		}
		System.out.println(cnt);
	}

}
