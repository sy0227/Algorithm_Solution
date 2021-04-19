package swea;

import java.util.Scanner;

public class Solution_D3_5607 {
	static final int MOD = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1 ; test<=T ; test++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			long ans = nCr(N, R, MOD);
			System.out.println("#"+test+" "+ans);
		}
	}

	private static long nCr(int n, int r, int mod) {
		if(r == 0) return 1L;
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i = 1 ; i<=n ; i++) {
			fac[i] = fac[i-1]*i%mod;
		}
		return (fac[n]*power(fac[r], mod-2, mod)%mod*power(fac[n-r], mod-2, mod)%mod)%mod;
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		x %= p;
		while(y>0) {
			if(y%2 == 1) res = (res*x)%p;
			y = y>>1;
			x = (x*x)%p;
		}
		return res;
	}

}
