package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<int[]>(); // [0] : 인덱스, [1] : 높이
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i<N ; i++) {
			int height = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1] < height) stack.pop(); // 지금 탑이 더 높은 경우에는 stack.pop()
				else { // 지금 탑이 더 낮은 경우 => 배열에 이전으로 높은 탑의 인덱스 저장
					sb.append(stack.peek()[0]+1);
					break;
				}
			}
			if(stack.isEmpty()) sb.append(0); // 수신할 탑이 없는 경우 (맨 앞은 자동으로 0)
			stack.push(new int[] {i, height});
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
