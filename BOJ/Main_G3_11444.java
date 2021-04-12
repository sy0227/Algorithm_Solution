package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_G3_11444 {
	static HashMap<Long, Long> map = new HashMap<Long, Long>();
    static final long mod = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		System.out.println(fibo(N));
	}

	private static long fibo(long n) {
		if(n<=0) return 0;
		else if(n == 1 || n == 2) return 1;
		else if(map.containsKey(n)) return map.get(n);
		else {
			if(n%2 == 1) {
				long m = (n+1)/2;
				long first = fibo(m);
				long second = fibo(m-1);
				map.put(n, (first*first+second*second)%mod);
				return map.get(n);
			}
			else {
				long m = n/2;
				long first = fibo(m-1);
				long second = fibo(m);
				map.put(n, (2*first+second)*second%mod);
				return map.get(n);
			}
		}
	}

}
