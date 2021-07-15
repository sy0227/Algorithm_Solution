package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G5_2671 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String pattern = "(100+1+|01)+";
		System.out.println((line.matches(pattern)? "SUBMARINE" : "NOISE"));
	}

}
