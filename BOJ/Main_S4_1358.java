package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1358 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int X_end = X+W, Y_end = Y+H;
		int R = H/2, Y_half = Y+R;
		int ans = 0;
		for(int p = 0 ; p<P ; p++) {
			st = new StringTokenizer(br.readLine());
			int player_x = Integer.parseInt(st.nextToken());
			int player_y = Integer.parseInt(st.nextToken());
			if((player_x>=X && player_x<=X_end && player_y>=Y && player_y<=Y_end)
					|| isCourtIn(player_x, player_y, X, Y_half)<=R
					|| isCourtIn(player_x, player_y, X_end, Y_half)<=R ) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static double isCourtIn(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}

}
