package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_16916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		System.out.println(KMP(S, P));
	}

	private static int KMP(String s, String p) {
		int[] pi = getpi(p);
		int j = 0;
		for(int i = 0 ; i<s.length() ; i++) {
			while(j>0 && s.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(s.charAt(i) == p.charAt(j)) {
				if(j == p.length()-1) return 1;
				else j++;
			}
		}
		return 0;
	}

	private static int[] getpi(String p) {
		int[] pi = new int[p.length()];
		int j = 0;
		for(int i = 1 ; i<p.length() ; i++) {
			while(j>0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) pi[i] = j+=1;
		}
		return pi;
	}

}
