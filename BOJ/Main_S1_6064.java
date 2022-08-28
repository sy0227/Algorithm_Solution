package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_6064 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 0 ; test<T ; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int lcm = M*N / gcd(M, N);
			int n = 0, answer = -1;
			while(n*M < lcm) {
				if((n*M + x - y) % N == 0) {
					answer = n*M + x;
					break;
				}
				n++;
			}
			System.out.println(answer);
		}
	}

	private static int gcd(int m, int n) {
		if(n == 0) return m;
		return gcd(n, m%n);
	}

}
