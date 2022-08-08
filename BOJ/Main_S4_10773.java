package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S4_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int k = 0 ; k<K ; k++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) stack.push(num);
			else stack.pop();
		}
		int answer = 0;
		for(int i = 0, size = stack.size() ; i<size ; i++) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}

}
