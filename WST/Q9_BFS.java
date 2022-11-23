package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9_BFS {

	public static void main(String[] args) throws IOException {
		////////////////////////////////////////// 입력은 직접 하지 않아도 되기 때문에 볼 필요 X
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N*N map
		int fromX = Integer.parseInt(st.nextToken())-1; // 출발지 X좌표 
		int fromY = Integer.parseInt(st.nextToken())-1; // 출발지 Y좌표 
		int toX = Integer.parseInt(st.nextToken())-1; // 목적지 X좌표
		int toY = Integer.parseInt(st.nextToken())-1; // 목적지 Y좌표
		int[][] arr = new int[N][N];
		for(int i = 0 ; i<N ; i++) {
			String line = br.readLine();
			for(int j = 0 ; j<N ; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		////////////////////////////////////////// 여기까지가 기본으로 주어지는 코드. 밑에부터 작성
		
		// 지도에서 이동하면서 거치게 되는 칸의 개수를 저장해주기 위해 cntMap 생성. 단, 벽인 경우를 -1로 저장(칸 cnt를 늘려줄 예정이므로~)
		int[][] cntMap = new int[N][N];
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				if(arr[i][j] == 1) cntMap[i][j] = -1;
				else cntMap[i][j] = 0;
			}
		}
		
		// 출발지(fromX, fromY)로부터 목적지(toX, toY)까지의 최단거리를 구하면, 왕복이기 때문에 답은 2를 곱해주면 됨
		// 출발지로부터 4방향으로 탐색을 시작
		int answer = BFS(fromX, fromY, toX, toY, N, cntMap);
		System.out.println(answer*2);
	}

	private static int BFS(int fromX, int fromY, int toX, int toY, int N, int[][] cntMap) {
		// 4방향 탐색을 위한 방향 이동 arr 선언 (좌우상하 순으로 선언했는데 순서는 무관)
		int[] dx = {-1, 1, 0, 0};
    	int[] dy = {0, 0, -1, 1};
    	
    	// BFS는 큐 자료구조를 이용하여 탐색. => 맨 위에 import java.util.*;을 해줘야 사용 가능!
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {fromX, fromY}); // 첫 시작점을 큐에 담아줌
    	while(!queue.isEmpty()) {
    		// 4방향 탐색을 시작하고자 하는 중심지를 temp로 표시
    		int[] temp = queue.poll();
    		int tempX = temp[0];
    		int tempY = temp[1];
    		for(int i = 0 ; i<4 ; i++) {
    			// 4방향에 대해서 나아갈 좌표를 next로 표시
    			int nextX = tempX + dx[i];
    			int nextY = tempY + dy[i];
    			// 다음 번에 탐색할 좌표가 지도 범위 내에 있고 벽(-1)이 아닌지 판별하여 큐에 넣어주기
    			if(0<=nextX && nextX<N && 0<=nextY && nextY<N && cntMap[nextX][nextY] != -1) {
    				if(nextX == toX && nextY == toY) {
    					cntMap[nextX][nextY] = cntMap[tempX][tempY] + 1;
    					return cntMap[toX][toY];
    				}
    				queue.add(new int[] {nextX, nextY});
    				cntMap[nextX][nextY] = cntMap[tempX][tempY] + 1;
    			}
    		}
    	}
		return 0; // 문제에서 주어진 조건이 목적지에 도달하지 못하는 경우는 없다고 봤던 것 같으니 여기서 리턴될 가능성 X
	}
}

/* tc 1 => Answer 12
5 1 1 4 4
00000
00100
00100
01100
00100
 */

/* tc 2 => Answer 24
7 1 1 7 7
0100000
0001110
0111110
0111110
0111110
0111110
0000000
 */

/* tc 3 => Answer 10
7 2 1 4 4
0000000
0001010
0110010
0000110
0111110
0111110
0000000
 */