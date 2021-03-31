package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 1. a, c, i, n, t 미리 배워놓기
 * 2. 조합
 * 3. 이미 배웠는지 검사한 후에 배우지 않은 경우에는 선택
 * nCr = n-1Cr-1 + n-1Cr (선택한 경우 + 비선택한 경우)
 */
public class Main_G4_1062_배수연 {
	static int N, K;
	static int[] words;
	static int result;
	static int str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new int[N];
		result = 0;
		for(int i = 0 ; i<N ; i++) {
			String word = br.readLine();
			for(int c = 4 ; c<word.length()-4 ; c++) {
				words[i] |= 1<<(word.charAt(c)-'a');
			}
		}
		
		if(K<5) System.out.println(0);
		else if(K>=26) System.out.println(N);
		else {
			str = 0;
			for(int j = 0 ; j<26 ; j++) {
				if(j == 'a'-'a' || j == 'n'-'a' || j == 't'-'a' || j == 'i'-'a' || j == 'c'-'a') {
					str |= 1<<j;
				}
			}
			K -= 5;
			comb(0, 0, str);
			System.out.println(result);
		}
	}
//	private static void comb(int idx, int start) {
//		if(result == N) return;
//		if(idx == K) {
//			int cnt = 0;
//			for(int i = 0 ; i<N ; i++) {
//				if((str|words[i]) == str) cnt++;
//			}
//			result = Math.max(result, cnt);
//			return;
//		}
//		for(int i = start ; i<26 ; i++) {
//			if((str&1<<i) == 0) {
//				str |= 1<<i;
//				comb(idx+1, i);
//				str ^= 1<<i;
//			}
//		}
//	}
	private static void comb(int idx, int start, int flag) {
		if(result == N) return;
		if(idx == K) {
			int cnt = 0;
			for(int i = 0 ; i<N ; i++) {
				if((flag|words[i]) == flag) cnt++;
			}
			result = Math.max(result, cnt);
			return;
		}
		for(int i = start ; i<26 ; i++) {
			if((flag&1<<i) == 0) {
				flag |= 1<<i;
				comb(idx+1, i, flag);
			}
		}
	}
}
