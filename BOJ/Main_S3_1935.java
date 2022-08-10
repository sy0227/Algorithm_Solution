package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		int[] arr = new int[N];
		for(int n = 0 ; n<N ; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Stack<Double> stack = new Stack<>();
		for(int i = 0, len = line.length() ; i<len ; i++) {
			char ch = line.charAt(i);
			if(ch>='A' && ch<='Z') stack.push((double) arr[ch-'A']);
			else {
				double d1 = stack.pop();
				double d2 = stack.pop();
				double d3 = 0.0;
				switch (ch) {
					case '+': 
						d3 = d2+d1;
						break;
					case '-': 
						d3 = d2-d1;
						break;
					case '*': 
						d3 = d2*d1;
						break;
					case '/': 
						d3 = d2/d1;
						break;
				}
				stack.push(d3);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}

}
