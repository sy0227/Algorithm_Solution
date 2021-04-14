package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656 {
	static int N, W, H, ans;
	static int[][] map, originalMap;
	static int[] dropNumbers;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			originalMap = new int[H][W];
			ans = Integer.MAX_VALUE;
			for(int h = 0 ; h<H ; h++) {
				st = new StringTokenizer(br.readLine());
				for(int w = 0 ; w<W ; w++) {
					map[h][w] = Integer.parseInt(st.nextToken());
					originalMap[h][w] = map[h][w];
				}
			}
			
			// W에서 N개의 구슬을 떨어트리는 경우들 구하기 -> 중복순열
			// 모든 경우에 대해서 판별해야 하기 때문에 순열 만드는 메소드 안에서 다른 판별 함수 모두 실행
			dropNumbers = new int[N];
			makeDrop(0);
			
			System.out.println("#" + test + " " + ans);
		}
	}

	private static void makeDrop(int idx) {
		if(idx == N) {
			// 각 순열에 대해서 다 탐색해봐야 하기 때문에 원래 map 정보를 다시 가져옴
			for(int h = 0 ; h<H ; h++) {
				map[h] = Arrays.copyOfRange(originalMap[h], 0, W);
			}
			
			// 순열로 구해진 순서대로 구슬 떨어트리면서 벽돌 부수기, 아래로 밀기
			for (int d : dropNumbers) {
				breakBricks(d);
				pressDown();
			}
			
			// 마지막 남은 벽돌 수 구하면서 최소 구하기
			int sum = 0;
			for(int h = 0 ; h<H ; h++) {
				for(int w = 0 ; w<W ; w++) {
//					if(map[h][w]>0) sum += map[h][w];
					if(map[h][w]>0) sum++;
				}
			}
			ans = Math.min(ans, sum);
			
			return;
		}
		for(int i = 0 ; i<W ; i++) {
			dropNumbers[idx] = i;
			makeDrop(idx+1);
		}
		
	}

	private static void pressDown() {
		for(int w = 0 ; w<W ; w++) {
			Queue<Integer> pressQ = new LinkedList<Integer>();
			for(int h = H-1 ; h>=0 ; h--) {
				if(map[h][w]>0) {
					pressQ.offer(map[h][w]);
					map[h][w] = 0;
				}
			}
			int temp = H-1;
			while(!pressQ.isEmpty()) {
				map[temp--][w] = pressQ.poll();
			}
		}
		
	}

	private static void breakBricks(int col) {
		Queue<int[]> brickQ = new LinkedList<int[]>();
//		boolean[][] visited = new boolean[H][W];
		// col 별로 탐색하면서 맨 위의 값 (r, c, map[r][c]) queue에 넣기
		for(int h = 0 ; h<H ; h++) {
			if(map[h][col] > 0) {
				brickQ.offer(new int[] {h, col, map[h][col]});
				break;
			}
		}
		
		// 제거하는 범위 맨 끝에가 0이 아니라면 그 때의 정보 queue에 넣기
		while(!brickQ.isEmpty()) {
			int[] temp = brickQ.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			int temp_val = temp[2];
			
			// 벽돌 크기만큼 상하좌우에 있는 벽돌들 제거
			int nr = 0, nc = 0;
			for(int d = 0 ; d<4 ; d++) {
				for(int v = 0 ; v<temp_val ; v++) {
					nr = temp_x+dr[d]*v;
					nc = temp_y+dc[d]*v;
					if(nr>-1 && nr<H && nc>-1 && nc<W && map[nr][nc]>0) {
						brickQ.offer(new int[] {nr, nc, map[nr][nc]});
						map[nr][nc] = 0;
					}
				}
			}
		}
	}
}

/* input
5
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1
2 9 10
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
1 1 0 0 1 0 0 0 0
1 1 0 1 1 1 0 1 0
1 1 0 1 1 1 0 1 0
1 1 1 1 1 1 1 1 0
1 1 3 1 6 1 1 1 1
1 1 1 1 1 1 1 1 1
3 6 7
1 1 0 0 0 0
1 1 0 0 1 0
1 1 0 0 4 0
4 1 0 0 1 0
1 5 1 0 1 6
1 2 8 1 1 6
1 1 1 9 2 1
4 4 15
0 0 0 0 
0 0 0 0 
0 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 0 0 
1 0 5 0 
1 1 1 0 
1 1 1 9 
1 1 1 1 
1 6 1 2 
1 1 1 5 
1 1 1 1 
2 1 1 2 
4 12 15
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
*/

//#1 12
//#2 27
//#3 4
//#4 8
//#5 0
