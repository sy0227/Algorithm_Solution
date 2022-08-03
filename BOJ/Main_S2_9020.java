package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S2_9020 {
	static boolean[] prime = new boolean[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		getPrime();
		for(int test = 0 ; test<T ; test++) {
			int N = Integer.parseInt(br.readLine());
			int left = N/2, right = N/2;
			while(true) {
				if(!prime[left] && !prime[right]) {
					System.out.println(left+" "+right);
					break;
				}
				left--;
				right++;
			}
		}
	}

	private static void getPrime() {
		prime[0] = prime[1] = true;
		for(int i = 2 ; i<Math.sqrt(prime.length) ; i++) {
			if(!prime[i]) {
				for(int j = i*i ; j<prime.length ; j+=i) {
					prime[j] = true;
				}
			}
		}
	}

}
