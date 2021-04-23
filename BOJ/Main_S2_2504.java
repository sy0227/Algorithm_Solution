package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S2_2504 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(func(str));
	}

	private static int func(String str) {
		int sum = 0;
		int temp = 1;
		
		if(str.length()%2 == 1) return 0;
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i<str.length() ; i++) {
			char bracket = str.charAt(i);
			if(bracket == '(') {
				stack.push(bracket);
				temp *= 2;
			}
			else if(bracket == '[') {
				stack.push(bracket);
				temp *= 3;
			}
			else if(bracket == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					return sum = 0;
				}
				if(str.charAt(i-1) == '(') sum += temp;
				stack.pop();
				temp /= 2;
			}
			else if(bracket == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					return sum = 0;
				}
				if(str.charAt(i-1) == '[') sum += temp;
				stack.pop();
				temp /= 3;
			}
		}
		return sum;
	}
	
}
