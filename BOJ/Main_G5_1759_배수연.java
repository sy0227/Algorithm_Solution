package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1759_배수연 {
	static int L, C;
	static char[] alpha;
	static char[] words;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		words = new char[L];
		String line = br.readLine();
		for(int c = 0, k = 0 ; c<C ; c++, k+=2) {
			alpha[c] = line.charAt(k);
		}
		Arrays.sort(alpha);
		getWord(0, 0, 0, 0);
	}
	public static void getWord(int idx, int start, int vowel, int consonant) {
		if(idx == L) {
			if(vowel>=1 && consonant>=2) {
				for(int i = 0 ; i<L ; i++) {
					System.out.print(words[i]);
				}
				System.out.println();
			}
			return;
		}
		for(int i = start ; i<C ; i++) {
			char temp = alpha[i];
			words[idx] = temp;
			if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') getWord(idx+1, i+1, vowel+1, consonant);
			else getWord(idx+1, i+1, vowel, consonant+1);
		}
	}
}
