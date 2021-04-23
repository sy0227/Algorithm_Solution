package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115 {
	static int N, M, C;
	static int[][] map, profit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			profit = new int[N][N];
			for(int i = 0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j<N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+test+" "+getHoney());
		}
	}

	private static int getHoney() {
		int ans = 0;
		// 행 별로 연속된 M개씩 끊어보면서 부분집합 구하고 sum 저장해두기
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<=N-M ; j++) {
				makeSubset(i, j, 0, 0, 0); // 좌표 r, c, 개수 cnt, sum, 전체 제곱 합
			}
		}
		
		// A와 B가 일할 수 있는 구역마다 합 다 구해보고 최대값 얻기
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<=N-M ; j++) {
				ans = Math.max(ans, getSum(i, j)+profit[i][j]);
			}
		}
		return ans;
	}

	private static int getSum(int i, int j) {
		int sum = 0;
		// 같은 줄에 위치할 수 있는 경우
		for(int c = j+M ; c<=N-M ; c++) {
			sum = Math.max(sum, profit[i][c]);
		}
		// 다른 줄에 위치
		for(int r = i+1 ; r<N ; r++) {
			for(int c = 0 ; c<N ; c++) {
				sum = Math.max(sum,  profit[r][c]);
			}
		}
		return sum;
	}

	private static void makeSubset(int i, int j, int cnt, int sum, int total) {
		if(sum>C) return;
		if(cnt == M) {
			profit[i][j-M] = Math.max(profit[i][j-M], total);
			return;
		}
		makeSubset(i, j+1, cnt+1, sum+map[i][j], total+map[i][j]*map[i][j]);
		makeSubset(i, j+1, cnt+1, sum, total);
	}
}
/*
2
4 2 13
6 1 9 7
9 8 5 8
3 4 5 3
8 2 6 7
3 3 10
7 2 9
6 6 6
5 5 7
*/