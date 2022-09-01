package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_17281 {
	static int N, answer;
	static int[][] player;
	static int[] line;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		player = new int[N+1][10];
		line = new int[10];
		selected = new boolean[10];
		for(int i = 1 ; i<=N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j<=9 ; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selected[4] = true;
		line[4] = 1;
		answer = 0;
		perm(2);
		System.out.println(answer);
	}

	private static void perm(int num) {
		if(num == 10) {
			play();
			return;
		}
		for(int i = 1 ; i<=9 ; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			line[i] = num;
			perm(num+1);
			selected[i] = false;
		}
	}

	private static void play() {
		int score = 0;
		int currPlayer = 1;
		boolean[] base;
		for(int i = 1 ; i<=N ; i++) {
			int outcnt = 0;
			base = new boolean[4];
			outer: while(true) {
				for(int j = currPlayer ; j<=9 ; j++) {
					int hit = player[i][line[j]];
					switch (hit) {
						case 0: // 아웃
							outcnt++;
							break;
						case 1: // 1루타
							for(int k = 3 ; k>=1 ; k--) {
								if(base[k]) {
									if(k == 3) {
										score++; // 3루에 있던 사람 홈으로 들어오고 비우기
										base[k] = false;
										continue;
									}
									base[k] = false;
									base[k+1] = true;
								}
							}
							base[1] = true; // 1루로 전진
							break;
						case 2: // 2루타
							for(int k = 3 ; k>=1 ; k--) {
								if(base[k]) {
									if(k == 3 || k == 2) {
										score++; // 2, 3루에 있던 사람 홈으로 들어오고 비우기
										base[k] = false;
										continue;
									}
									base[k] = false;
									base[k+2] = true;
								}
							}
							base[2] = true; // 2루로 전진
							break;
						case 3: // 3루타
							for(int k = 3 ; k>=1 ; k--) {
								if(base[k]) {
									score++; // 모든 사람 홈으로 들어오고 비우기
									base[k] = false;
								}
							}
							base[3] = true; // 1루로 전진
							break;
						case 4: // 4루타
							for(int k = 1 ; k<=3 ; k++) {
								if(base[k]) {
									score++; // 모든 사람 홈으로 들어오고 비우기
									base[k] = false;
								}
							}
							score++;
							break;
					}
					if(outcnt == 3) {
						currPlayer = j+1;
						if(currPlayer == 10) currPlayer = 1;
						break outer;
					}
				}
				currPlayer = 1;
			}
		}
		answer = Math.max(answer, score);
	}
}
