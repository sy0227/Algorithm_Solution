package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_D4_5604 {
	static long nums[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1 ; test<=T ; test++) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			nums = new long[10];
			func(A, B);
			long ans = 0;
			for (long num : nums) {
				ans += num;
			}
			System.out.println("#"+test+" "+ans);
		}

	}

	private static void func(long A, long B) {
		long cnt = 0;
		long mul = 1;
		
		while(A<=B) {
			// A는 끝자리 0이 되도록 ++
			while(A%10 != 0 && A<=B) {
				saveToNum(A, mul);
				A++;
			}
			// B는 끝자리 9가 되도록 --
			while(B%10 != 9 && A<=B) {
				saveToNum(B, mul);
				B--;
			}
			// (B/10-A/10+1)*mul
			for(int i = 0 ; i<10 ; i++) {
				nums[i] += (B/10-A/10+1)*mul;
			}
			mul *= 10;
			A /= 10;
			B /= 10;
		}
	}

	private static void saveToNum(long num, long mul) {
		// 해당 수 개수 ++
		while(num>0) {
			int idx = (int) (num%10);
			nums[idx] += mul;
			num /= 10;
		}
	}
}
