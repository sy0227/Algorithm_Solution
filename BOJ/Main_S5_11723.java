package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		int x;
		StringBuilder sb = new StringBuilder();
		for(int m = 0 ; m<M ; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch (op) {
				case "add":
					x = Integer.parseInt(st.nextToken())-1;
					S |= 1<<x;
					break;
				case "remove":
					x = Integer.parseInt(st.nextToken())-1;
					S &= ~(1<<x);
					break;
				case "check":
					x = Integer.parseInt(st.nextToken())-1;
					int num = (S&(1<<x)) != 0? 1 : 0;
					sb.append(num+"\n");
					break;
				case "toggle":
					x = Integer.parseInt(st.nextToken())-1;
					S ^= (1<<x);
					break;
				case "all":
					S = (1<<21)-1;
					break;
				case "empty":
					S = 0;
					break;
				default:
					break;
			}
		}
		System.out.println(sb.toString());
	}
}
