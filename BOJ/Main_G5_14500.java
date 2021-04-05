package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14500 {
	static int N, M;
	static int[][] map;
	static int[][][] poly = {
			{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // ㅁ
			{{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // ㅡ, ㅣ
			{{0, 0}, {0, 1}, {0, 2}, {0, 3}}, 
			{{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // ㄱ, ㄴ
			{{0, 0}, {0, 1}, {0, 2}, {1, 0}}, 
			{{0, 0}, {0, 1}, {1, 1}, {2, 1}}, 
			{{1, 0}, {1, 1}, {1, 2}, {0, 2}}, 
			{{0, 1}, {1, 1}, {2, 1}, {2, 0}},
			{{0, 0}, {1, 0}, {1, 1}, {1, 2}}, 
			{{0, 0}, {0, 1}, {1, 0}, {2, 0}}, 
			{{0, 0}, {0, 1}, {0, 2}, {1, 2}}, 
			{{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // z
			{{0, 1}, {0, 2}, {1, 0}, {1, 1}}, 
			{{0, 1}, {1, 1}, {1, 0}, {2, 0}}, 
			{{0, 0}, {0, 1}, {1, 1}, {1, 2}}, 
			{{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // ㅜ
			{{0, 1}, {1, 0}, {1, 1}, {1, 2}}, 
			{{1, 0}, {0, 1}, {1, 1}, {2, 1}}, 
			{{0, 0}, {1, 0}, {2, 0}, {1, 1}}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int max = 0;
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		for(int n = 0 ; n<N ; n++) {
			for(int m = 0 ; m<M ; m++) {
				for(int i = 0 ; i<19 ; i++) {
					int temp = 0;
					for(int j = 0 ; j<4 ; j++) {
						int nr = n+poly[i][j][0];
						int nc = m+poly[i][j][1];
						if(nr>-1 && nr<N && nc>-1 && nc<M) {
							temp += map[nr][nc];
						}
					}
					max = Math.max(max, temp);
				}
			}
		}
		System.out.println(max);
	}

}
