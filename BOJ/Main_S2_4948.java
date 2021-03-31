package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S2_4948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] isPrime = new boolean[250000];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2 ; i<500 ; i++) {
			for(int j = i*i ; j<250000 ; j += i) {
				if(isPrime[i]) isPrime[j] = false;
			}
		}
		
		while(true) {
			int N = sc.nextInt();
			if(N == 0) break;
			int cnt = 0;
			for(int i = N+1 ; i<=2*N ; i++) {
				if(isPrime[i]) cnt++;
			}
			System.out.println(cnt);
		}
	}
}
