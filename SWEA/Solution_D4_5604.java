package swea;

import java.util.Scanner;

public class Solution_D4_5604 {
	static long nums[];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1 ; test<=T ; test++) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			nums = new long[10];
			long mul = 1;
			
			while(A<=B) {
				// B는 끝자리 9가 되도록 --
				while(B%10 != 9 && A<=B) {
					saveToNum(B, mul);
					B--;
				}
				if(A>B) break;
				// A는 끝자리 0이 되도록 ++
				while(A%10 != 0 && A<=B) {
					saveToNum(A, mul);
					A++;
				}
				
				A /= 10;
				B /= 10;
				
				// (B-A+1)*mul
				for(int i = 0 ; i<10 ; i++) {
					nums[i] += (B-A+1)*mul;
				}
				mul *= 10;
			}
			long ans = 0;
			for(int i = 0 ; i<10 ; i++) {
				ans += nums[i]*i;
			}
			System.out.println("#"+test+" "+ans);
		}

	}

	private static void saveToNum(long num, long mul) {
		// 해당 수 개수 ++
		while(num>0) {
			String s = String.valueOf(num);
			int idx = s.charAt(s.length()-1)-'0';
			nums[idx] += mul;
			num /= 10;
		}
	}
}
