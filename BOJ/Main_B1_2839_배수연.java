package boj;

import java.util.Scanner;

public class Main_B1_2839_배수연 {
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		possible(N);
		possible2(N);
		System.out.println(ans);
	}
	public static void possible(int N) {
		while(true) {
			if(N%5 == 0) {
				ans += N/5;
				break;
			}
			N -= 3;
			ans++;
			if(N == 0) break;
			if(N < 0) {
				ans = -1;
				break;
			}
		}
	}
	public static void possible2(int N) {
		ans = N/5;
		switch (N%5) {
		case 0: // 나머지가 0인 경우 : ans
			break;
		case 1: // 나머지가 1인 경우 : 5kg봉지--, 3kg봉지+=2 => ans++
		case 3: // 나머지가 3인 경우 : 3kg봉지++ => ans++
			ans++;
			break;
		case 2: // 나머지가 2인 경우 : N/5<2면 나누어 떨어지지 않음, N/5>=2면 5kg봉지-=2, 3kg봉지+=4 => ans+=2
			if(ans<2) ans = -1;
			else ans += 2;
			break;
		case 4: // 나머지가 4인 경우 : N/5<1면 나누어 떨어지지 않음, N/5>=1면 5kg봉지--, 3kg봉지+=3 => ans+=2
			if(ans<1) ans = -1;
			else ans += 2;
			break;
		default:
			break;
		}
	}

}
