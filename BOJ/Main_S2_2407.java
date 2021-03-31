package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_S2_2407 {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for(int i = 0; i < M; i++){
            a = a.multiply(new BigInteger(String.valueOf(N - i)));
            b = b.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        BigInteger ans = a.divide(b);
		System.out.println(ans);
	}

}
/*
100 6

1192052400
*/