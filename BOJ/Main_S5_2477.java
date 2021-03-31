package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2477 {
	static int K;
	static int[][] map;
	static int W, H;
	static int little_w, little_h;
	static int idx_W, idx_H, idx_start;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		map = new int[6][2];
		W = 0;
		H = 0;
		for(int i = 0 ; i<6 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i<6 ; i++) { // 최대
			if(map[i][0] == 1 || map[i][0] == 2) W = Math.max(W, map[i][1]);
			else if(map[i][0] == 3 || map[i][0] == 4) H = Math.max(H, map[i][1]);
		}
		int min = 1;
		for(int i = 0 ; i<6 ; i++) { // 최소
			if(map[(i+5)%6][0] == map[(i+1)%6][0]) min *= map[i][1];
		}

		System.out.println(((H*W)-min)*K);
	}

}
