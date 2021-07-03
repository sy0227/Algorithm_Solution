package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Contact - 문자열, 정규표현식
 * 정규표현식으로 해결하면 된다는건 거의 문제가 다 알려줬다.
 * 주어진 문자열이 문제에서 제시된 패턴과 일치하는지 여부만 검사하면 되는 문제였는데, 자바 정규표현식을 검색해보니 문자열.matches(regex)로 검사할 수 있었다.
 * 문제에서 패턴을 그대로 복사해서 코드에 입력했는데 | 기호 양 옆에 띄어쓰기가 포함되어서 틀린 답이 나왔다. 짧은 코드여서 틀릴 곳이 없어서 문제를 금방 찾아내서 고쳤다.
 */

public class BOJ_G5_1013 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			String line = br.readLine();
			String pattern = "(100+1+|01)+";
			String ans = (line.matches(pattern))? "YES" : "NO";
			System.out.println(ans);
		}
	}
}
