package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2578 {
	static int[][] map = new int[5][5];
	static boolean isCorner;
	static int bingo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int r = 0 ; r<5 ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c<5 ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		boolean flag = false;
		for(int r = 0 ; r<5 ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c<5 ; c++) {
				int call = Integer.parseInt(st.nextToken());
				find(call);
				cnt++;
				if(check_bingo(r, c)) {
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		System.out.println(cnt);
	}
	private static void find(int call) {
		for(int r = 0 ; r<5 ; r++) {
			for(int c = 0 ; c<5 ; c++) {
				if(map[r][c] == call) map[r][c] = 0;
			}
		}
	}
	private static boolean check_bingo(int r, int c) {
		bingo = 0;
		int slashcnt1 = 0;
		int slashcnt2 = 0;
		int rcnt = 0;
		int ccnt = 0;
		for(int i = 0 ; i<5 ; i++) {
			// 대각선 빙고 확인
			if(map[i][i] == 0) slashcnt1++;
			if(map[i][4-i] == 0) slashcnt2++;
			
			rcnt = 0;
			ccnt = 0;
			for(int j = 0 ; j<5 ; j++) {
				if(map[i][j] == 0) rcnt++;
				if(map[j][i] == 0) ccnt++;
			}
			if(rcnt == 5) bingo++;
			if(ccnt == 5) bingo++;
		}
		if(slashcnt1 == 5) bingo++;
		if(slashcnt2 == 5) bingo++;
		
		if(bingo >= 3) return true;
		else return false;
	}
}
/*
11 12 2 24 10
16 1 13 3 25
6 20 5 21 17
19 4 8 14 9
22 15 7 23 18
5 10 7 16 2
4 22 8 17 13
3 18 1 6 25
12 19 23 14 21
11 24 9 20 15
*/