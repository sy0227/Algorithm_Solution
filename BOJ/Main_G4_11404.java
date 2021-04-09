package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_11404 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0 ; i<N ; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(map[from][to], cost);
		}
		
//		for(int i = 0 ; i<N ; i++) {
//			for(int j = 0 ; j<N ; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int k = 0 ; k<N ; k++) {
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
						if(i == j) continue;
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
						
				}
			}
		}
		
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				System.out.print((map[i][j]==Integer.MAX_VALUE)? "0 " : map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
