package boj;

import java.util.Scanner;

public class Main_B2_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] cnt = new int[N+1];
		int ans = 0;
		int temp = 1;
		cnt[1] = 1;
		while(true) {
			if(cnt[temp] == M) {
				break;
			}
			ans++;
			if(cnt[temp]%2 == 0) {
				if(temp-L <= 0) temp = temp-L+N;
				else temp -= L;
			}
			else {
				if(temp+L>N) temp = temp+L-N;
				else temp += L;
			}
			cnt[temp]++;
		}
		System.out.println(ans);
	}

}
