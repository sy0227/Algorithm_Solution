package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_Str {

	public static void main(String[] args) throws IOException {
		////////////////////////////////////////// 입력은 직접 하지 않아도 되기 때문에 볼 필요 X 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String userId = st.nextToken();
		String userPw = st.nextToken();
		if(idCheck01(userId) && pwCheck01(userPw)) System.out.println("성공01!"); // ASCII Code 이용
		if(idCheck02(userId) && pwCheck02(userPw)) System.out.println("성공02!"); // 자바 내장 메소드 이용
	}

	////////////////////////////////////////// ASCII Code 이용
	private static boolean idCheck01(String userId) {
		if(userId.length() < 4 || userId.length() > 12) {
			System.out.println("유효하지 않은 아이디");
			return false;
		}
		// 여기부터 작성 - 대문자(65~90), 소문자(97~122), 숫자(48~57), 언더바(_)(95)만 가능
		for(int i = 0 ; i<userId.length() ; i++) {
			int ASCIIofChar = userId.charAt(i);
			if(!((65<=ASCIIofChar && ASCIIofChar<=90) || (97<=ASCIIofChar && ASCIIofChar<=122) || (48<=ASCIIofChar && ASCIIofChar<=57) || ASCIIofChar == 95)) {
				System.out.println("유효하지 않은 아이디");
				return false;
			}
		}
		return true;
	}

	private static boolean pwCheck01(String userPw) {
		if(userPw.length() < 4 || userPw.length() > 12) {
			System.out.println("유효하지 않은 패스워드");
			return false;
		}
		// 여기부터 작성 - 대문자(65~90), 소문자(97~122), 숫자(48~57)가 1번 이상씩 포함
		int upperCnt = 0, lowerCnt = 0, numberCnt = 0;
		for(int i = 0 ; i<userPw.length() ; i++) {
			int ASCIIofChar = userPw.charAt(i);
			if(65<=ASCIIofChar && ASCIIofChar<=90) upperCnt++;
			if(97<=ASCIIofChar && ASCIIofChar<=122) lowerCnt++;
			if(48<=ASCIIofChar && ASCIIofChar<=57) numberCnt++;
		}
		if(upperCnt == 0 || lowerCnt == 0 || numberCnt == 0) {
			System.out.println("유효하지 않은 패스워드");
			return false;
		}
		return true;
	}
	
	////////////////////////////////////////// 자바 내장 메소드 이용
	private static boolean idCheck02(String userId) {
		if(userId.length() < 4 || userId.length() > 12) {
			System.out.println("유효하지 않은 아이디");
			return false;
		}
		// 여기부터 작성 - 대문자(65~90), 소문자(97~122), 숫자(48~57), 언더바(_)(95)만 가능
		for(int i = 0 ; i<userId.length() ; i++) {
			int ASCIIofChar = userId.charAt(i);
			if(!(Character.isUpperCase(ASCIIofChar) || Character.isLowerCase(ASCIIofChar) || Character.isDigit(ASCIIofChar) || ASCIIofChar == 95)) {
				System.out.println("유효하지 않은 아이디");
				return false;
			}
		}
		return true;
	}

	private static boolean pwCheck02(String userPw) {
		if(userPw.length() < 4 || userPw.length() > 12) {
			System.out.println("유효하지 않은 패스워드");
			return false;
		}
		// 여기부터 작성 - 대문자(65~90), 소문자(97~122), 숫자(48~57)가 1번 이상씩 포함
		int upperCnt = 0, lowerCnt = 0, numberCnt = 0;
		for(int i = 0 ; i<userPw.length() ; i++) {
			int ASCIIofChar = userPw.charAt(i);
			if(Character.isUpperCase(ASCIIofChar)) upperCnt++;
			if(Character.isLowerCase(ASCIIofChar)) lowerCnt++;
			if(Character.isDigit(ASCIIofChar)) numberCnt++;
		}
		if(upperCnt == 0 || lowerCnt == 0 || numberCnt == 0) {
			System.out.println("유효하지 않은 패스워드");
			return false;
		}
		return true;
	}
}

/* tc 1 => 유효하지 않은 아이디
impossibleIdToolong Pw1234
 */

/* tc 2 => 유효하지 않은 아이디
id12! Pw1235
 */

/* tc 3 => 유효하지 않은 패스워드
id12_ pass
 */

/* tc 4 => 유효하지 않은 패스워드
id12_ passWORD
 */

/* tc 5 => 유효하지 않은 패스워드
id12_ pass12
 */

/* tc 6 => 성공!
id12_ Pw1235
 */

// 참조 url : https://needjarvis.tistory.com/227