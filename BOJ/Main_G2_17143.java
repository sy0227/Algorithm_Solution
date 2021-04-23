package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G2_17143 {
	static int R, C, M, ans;
	static Shark[][] map;
	static ArrayList<Shark> list;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	
	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new Shark[R+1][C+1];
		list = new ArrayList<Shark>();
		
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 이동 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			// 지도에 상어 정보들을 모두 표시해두기 s, d, z
			Shark shark = new Shark(r, c, s, d, z);
			map[r][c] = shark;
			// 상어 이동을 위한 큐에도 다 넣어두기
			list.add(shark);
		}
		
		// 낚시왕을 오른쪽으로 한 칸 이동 (열 기준 탐색)
		for(int c = 1 ; c<=C ; c++) {
			// 낚시왕의 열에서 가장 가까운 행에 있는 상어 잡기 (지도에서 해당 상어 정보 지우고 상어 크기 ++)
			for(int r = 1 ; r<=R ; r++) {
				if(map[r][c] != null) {
					ans += map[r][c].z;
					list.remove(map[r][c]);
					break;
				}
			}
			
			// 상어 이동
			for (Shark shark : list) {
				int nr = shark.r;
				int nc = shark.c;
				int s = shark.s;
				int d = shark.d;
				switch (d) {
				case 1:
				case 2:
					s = s%(R*2-2);
					for(int i = 0 ; i<s ; i++) {
						if(nr == 1) d = 2;
						else if(nr == R) d = 1;
						nr += dr[d];
					}
					shark.r = nr;
					shark.d = d;
					break;
				case 3:
				case 4:
					s = s%(C*2-2);
					for(int i = 0 ; i<s ; i++) {
						if(nc == 1) d = 3;
						else if(nc == C) d = 4;
						nc += dc[d];
					}
					shark.c = nc;
					shark.d = d;
					break;
				default:
					break;
				}
			}
			
			// 상어가 겹치는지 확인해보고 겹치면 사이즈 큰 것만 남기기
			map = new Shark[R+1][C+1];
			int size = list.size();
			for(int i = size-1 ; i>=0 ; i--) {
				Shark s = list.get(i);
				if(map[s.r][s.c] == null) map[s.r][s.c] = s;
				else {
					if(s.z > map[s.r][s.c].z) {
						list.remove(map[s.r][s.c]);
						map[s.r][s.c] = s;
					}
					else list.remove(s);
				}
			}
		}
		System.out.println(ans);
	}
}
