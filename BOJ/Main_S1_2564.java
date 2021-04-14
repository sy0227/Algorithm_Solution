package boj;

import java.util.Scanner;

public class Main_S1_2564 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		int B = sc.nextInt();
		int[][] loc = new int[B+1][3]; // [동서남북, r좌표, c좌표]
		int ans = 0;
		for(int b = 0 ; b<B+1 ; b++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			switch (x) {
			case 1: // 북
				loc[b] = new int[] {x, 0, y};
				break;
			case 2: // 남
				loc[b] = new int[] {x, H, y};
				break;
			case 3: // 서
				loc[b] = new int[] {x, y, 0};
				break;
			case 4: // 동
				loc[b] = new int[] {x, y, W};
				break;
			default:
				break;
			}
		}
		for(int b = 0 ; b<B ; b++) {
			// 남북 반대쪽에 위치한 경우
			int len = 0;
			if((loc[B][0] == 1 && loc[b][0] == 2) || (loc[B][0] == 2 && loc[b][0] == 1)) {
				if((loc[B][2]+loc[b][2])>(W-loc[B][2])+(W-loc[b][2])) len = (W-loc[B][2])+(W-loc[b][2]);
				else len = loc[B][2]+loc[b][2];
				ans += len+H;
			}
			else if((loc[B][0] == 3 && loc[b][0] == 4) || (loc[B][0] == 4 && loc[b][0] == 3)) {
				if((loc[B][1]+loc[b][1])>(H-loc[B][1])+(H-loc[b][1])) len = (H-loc[B][1])+(H-loc[b][1]);
				else len = loc[B][1]+loc[b][1];
				ans += len+W;
			}
			else {
				len = Math.abs(loc[B][1]-loc[b][1]) + Math.abs(loc[B][2]-loc[b][2]);
				ans += len;
			}
		}
		System.out.println(ans);
	}

}
