package BOJ;

import java.util.Scanner;

public class Main_S4_2960 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] prime = new boolean[N+1];
		int cnt = 0;
		for(int n = 2 ; n<=N ; n++) {
			prime[n] = true;
		}
		for(int i = 2 ; i<=N ; i++) {
			for(int j = i ; j<=N ; j+=i) {
				if(!prime[j]) continue;
				prime[j] = false;
				cnt++;
				if(K == cnt) {
					System.out.println(j);
					break;
				}
			}
		}
	}

}
