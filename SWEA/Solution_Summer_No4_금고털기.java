package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_Summer_No4_금고털기 {
	static int[] aclockwise = {1, 3, 5, 7};
	static int[] clockwise = {1, 2, 4, 6};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			char[] from = br.readLine().toCharArray();
			char[] to = br.readLine().toCharArray();
			int ans = 0;
			for(int i = 0 ; i<4 ; i++) {
				// to에 있는 문자가 크면 시계=to-from, 반시계=26-(to-from)
				// from에 있는 문자가 크면 반시계=from-to, 시계=26-(from-to)
				int clock = 0, aclock = 0;
				if(from[i]<to[i]) {
					clock = to[i]-from[i];
					aclock = 26-clock;
					if(clock*clockwise[i]<aclock*aclockwise[i]) ans += clock*clockwise[i];
					else ans += aclock*aclockwise[i];
				}
				else {
					aclock = from[i]-to[i];
					clock = 26-aclock;
					if(clock*clockwise[i]<aclock*aclockwise[i]) ans += clock*clockwise[i];
					else ans += aclock*aclockwise[i];
				}
			}
			System.out.println("#"+test+" "+ans);
		}
	}
}
/*
ABCDEFGHIJKLMNOPQRSTUVWXYZ
Y->Z : 시계1
T->I : 반시계11
U->Q : 반시계4
Y->Z : 시계1

5
FDSA
JATY
AAAA
ZZZZ
SSSS
SSSS
ZXKC
QWWW
YTUY
ZIQZ
*/