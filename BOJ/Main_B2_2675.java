package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 0 ; test<T ; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			System.out.println(recur(R, S));
		}
	}

	private static String recur(int R, String S) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0, length = S.length() ; i<length ; i++) {
			char ch = S.charAt(i);
			for(int r = 0 ; r<R ; r++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
