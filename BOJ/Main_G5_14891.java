package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14891 {
	static int[][] arr = new int[4][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i<4 ; i++) {
			String line = br.readLine();
			for(int j = 0 ; j<8 ; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for(int k = 0 ; k<K ; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken()); // 1 : 시계, -1 : 반시계
			
			left(idx-1, -dir);
			right(idx+1, -dir);
			rotate(idx, dir);
		}
		int answer = 0;
		for(int i = 0 ; i<4 ; i++) {
			answer += arr[i][0] * (1<<i);
		}
		System.out.println(answer);
	}

	private static void left(int idx, int dir) {
		if(idx<0) return;
		if(arr[idx][2] != arr[idx+1][6]) {
			left(idx-1, -dir);
			rotate(idx, dir);
		}
	}
	private static void right(int idx, int dir) {
		if(idx>3) return;
		if(arr[idx][6] != arr[idx-1][2]) {
			right(idx+1, -dir);
			rotate(idx, dir);
		}
	}
	private static void rotate(int idx, int dir) {
		if(dir == 1) {
			int temp = arr[idx][7];
			for(int i = 7 ; i>0 ; i--) {
				arr[idx][i] = arr[idx][i-1];
			}
			arr[idx][0] = temp;
		}
		else {
			int temp = arr[idx][0];
			for(int i = 0 ; i<7 ; i++) {
				arr[idx][i] = arr[idx][i+1];
			}
			arr[idx][7] = temp;
			
		}
	}


}
