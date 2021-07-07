package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 소문난 칠공주 - BFS, DFS
 * 전체 25명의 학생 중 DFS로 7명 선택, 그 중 S가 4 이상인 경우에 7명 모두가 인접해있는지 확인
 * 선택한 7명 중 한 학생 기준으로 BFS 시작, 4방 탐색의 다음 노드가 princess로 저장되어 있으면 같은 그룹으로 판단하고 쭉 연결
 * 사람 수 세주면서 BFS 탐색 끝났을 때 7명이면 가능한 경우, 그렇지 않으면 불가능한 경우로 판단 
 */

public class BOJ_G3_1941 {
	static int ans;
	static int[] numbers;
	static char[][] map;
	static boolean[] princess, visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 0;
		numbers = new int[7];
		map = new char[5][5];
		princess = new boolean[25];
		for(int i = 0 ; i<5 ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		makeSeven(0, 0, 0);
		System.out.println(ans);
	}

	private static void makeSeven(int idx, int cnt, int cntS) {
		if(cnt == 7) {
			if(cntS >= 4) {
				if(isGroup()) ans++;
			}
			return;
		}
		for(int i = idx ; i<25 ; i++) {
			princess[i] = true;
			numbers[cnt] = i;
			if(map[i/5][i%5] == 'S') makeSeven(i+1, cnt+1, cntS+1);
			else makeSeven(i+1, cnt+1, cntS);
			princess[i] = false;
		}
	}

	private static boolean isGroup() {
		int cnt = 1;
		visited = new boolean[25];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(numbers[0]);
		visited[numbers[0]] = true;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int d = 0 ; d<4 ; d++) {
				int nr = (temp/5)+dr[d];
				int nc = (temp%5)+dc[d];
				int next = nr*5+nc;
				if(nr>-1 && nr<5 && nc>-1 && nc<5 && !visited[next] && princess[next]) {
					cnt++;
					queue.add(next);
					visited[next] = true;
				}
			}
		}
		if(cnt == 7) return true;
		else return false;
	}
}
