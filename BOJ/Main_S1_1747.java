package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_1747 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = N;
		while(true) {
			if(isPrime(num) && isPalindrome(num)) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}

	private static boolean isPalindrome(int num) {
		String str = Integer.toString(num);
		int left = 0, right = str.length()-1;
		while(left < right) {
			if(str.charAt(left) != str.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}

	private static boolean isPrime(int n) {
		if(n<=1) return false;
		if(n == 2) return true;
		if(n%2 == 0) return false;
		for(int i = 3 ; i<=Math.sqrt(n) ; i+=2) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
