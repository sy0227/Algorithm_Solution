package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		for(int i = 0, length = line.length() ; i<length ; i++) {
			char ch = line.charAt(i);
			if(ch == '<') {
				flag = true;
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(ch);
			}
			else if(ch == '>') {
				flag = false;
				System.out.print(ch);
			}
			else if(flag) System.out.print(ch);
			else if(!flag) {
				if(ch == ' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(ch);
				}
				else stack.add(ch);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

}
