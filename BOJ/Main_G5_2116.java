package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_2116 {
	static int N, ans;
	static int[][] dice;
	static boolean[][] visited;
	static int[] op = {0, 6, 4, 5, 2, 3, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		dice = new int[N][7];
		ans = 0;
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i<=6 ; i++) {
				dice[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		func();
		System.out.println(ans);
	}

	private static void func() {
		int up = 0;
        for (int num = 1; num <= 6; num++) {
            visited = new boolean[N][7];
            for (int f = 1; f <= 6; f++) {
                if(dice[0][f] == num) {
                    up = dice[0][f];
                    visited[0][f] = visited[0][op[f]] = true;
                    break;
                }
            }
        
            for (int i = 1; i < N; i++) {
                for (int f = 1; f <= 6; f++) {
                    if(dice[i][f] == up) {
                        up = dice[i][op[f]];
                        visited[i][f] = visited[i][op[f]] = true;
                        break;
                    }
                }
            }
            ans = Math.max(ans, sum());
        } 
	}

	private static int sum() {
		int sum = 0;
		for(int n = 0 ; n<N ; n++) {
			int max = 0;
			for(int i = 1 ; i<=6 ; i++) {
				if(!visited[n][i]) max = Math.max(max, dice[n][i]);
			}
			sum += max;
		}
		return sum;
	}
}
