package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2527_배수연 {
	static int[][] squares = new int[2][4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int test = 0 ; test<4 ; test++) {
			st = new StringTokenizer(br.readLine());
			String ans = "a";
			for(int i = 0 ; i<2 ; i++) {
				squares[i][0] = Integer.parseInt(st.nextToken());
				squares[i][1] = Integer.parseInt(st.nextToken());
				squares[i][2] = Integer.parseInt(st.nextToken());
				squares[i][3] = Integer.parseInt(st.nextToken());
			}
			if((squares[0][0] == squares[1][2] && squares[0][3] == squares[1][1]) || 
					(squares[0][2] == squares[1][0] && squares[0][3] == squares[1][1]) || 
					(squares[0][0] == squares[1][2] && squares[0][1] == squares[1][3]) || 
					(squares[0][2] == squares[1][0] && squares[0][1] == squares[1][3])) {
				ans = "c";
			}
			else if((squares[0][3] == squares[1][1]) || (squares[0][2] == squares[1][0]) || (squares[0][1] == squares[1][2]) || 
					(squares[0][0] == squares[1][3]) || (squares[0][1] == squares[1][3]) || (squares[0][0] == squares[1][2])) {
				ans = "b";
			}
			else if((squares[0][2]<squares[1][0]) || (squares[0][3]<squares[1][1]) || 
					(squares[0][0]>squares[1][2]) || (squares[0][1]>squares[1][3])){
				ans = "d";
			}
			else if(((squares[0][2]>squares[1][0] && squares[0][3]>squares[1][1]) ||
					squares[0][1]<squares[1][3] && squares[0][0]<squares[1][2]) ) {
				ans = "a";
			}
			System.out.println(ans);
		}
	}
	
}
