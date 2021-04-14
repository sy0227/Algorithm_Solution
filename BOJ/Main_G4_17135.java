package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_17135 {
	static int N, M, D, ans;
	static int[] arrow;
	static int[][] map, originalMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		ans = 0;
		arrow = new int[3];
		map = new int[N][M];
		originalMap = new int[N][M];
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m<M ; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				originalMap[n][m] = map[n][m];
			}
		}
		
		// 너비 M 중에서 3명의 궁수를 어떻게 배치할 것인지 조합으로 경우 구하기 mC3
		// 각각 경우에 대해서 적을 제거하고 남은 적의 최소 수 갱신
		setArrow(0, 0);
		System.out.println(ans);
	}

	private static void setArrow(int idx, int start) {
		if(idx == 3) {
			// map을 초기 상태로 다시 초기화
			for(int n = 0 ; n<N ; n++) {
				map[n] = Arrays.copyOfRange(originalMap[n], 0, M);
			}
			
			attack();
			return;
		}
		for(int i = start ; i<M ; i++) {
			arrow[idx] = i;
			setArrow(idx+1, i+1);
		}
	}

	private static void attack() {
		int cnt = 0;
		
		// N번 플레이
		for(int i = 0 ; i<N ; i++) {
			int[][] enemy = new int[N][M];
			
			// 3명의 궁수 각각에 대하여 최단거리의 적 구하기
			for(int ar = 0 ; ar<3 ; ar++) {
				int col = arrow[ar];
				int minDis = Integer.MAX_VALUE;
				int min_X = 0;
				int min_Y = 0;
				
				for(int n = 0 ; n<N ; n++) {
					for(int m = 0 ; m<M ; m++) {
						if(map[n][m] == 1) {
							int distance = Math.abs(N-n) + Math.abs(col-m);
							if(distance > D) continue;
							if(minDis > distance) {
								minDis = distance;
								min_X = n;
								min_Y = m;
							}
							else if(minDis == distance) { // 왼쪽부터 처리
								if(min_Y > m) {
									min_X = n;
									min_Y = m;
								}
							}
						}
					}
				}
				// 최단거리에 위치한 적이 D 이하에 있을 때, enemy 배열의 값 ++
				if(minDis <= D) enemy[min_X][min_Y]++;
			}
			
			// enemy 배열 값이 1 이상인 경우에 그 칸을 0으로 만들어주기
			for(int n = 0 ; n<N ; n++) {
				for(int m = 0 ; m<M ; m++) {
					if(enemy[n][m]>0) {
						map[n][m] = 0;
						cnt++;
					}
				}
			}
			
			// map[n]을 한 칸씩 아래로 밀고 map[0]을 0으로 초기화
			for(int n = N-1 ; n>=1 ; n--) {
				for(int m = 0 ; m<M ; m++) {
					map[n][m] = map[n-1][m];
				}
			}
			
			Arrays.fill(map[0], 0);
		}
		// 제거한 적의 수 최대값 갱신
		ans = Math.max(ans, cnt);
	}

}
