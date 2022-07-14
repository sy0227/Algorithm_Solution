package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int num;
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			num = Integer.parseInt(st.nextToken());
			if(isPrime(num)) answer++;
		}
		System.out.println(answer);
	}

	private static boolean isPrime(int n) {
		if(n <= 1) return false;
		if(n == 2) return true;
		if(n%2 == 0) return false;
		for(int i = 3 ; i<=(int)Math.sqrt(n) ; i += 2) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
