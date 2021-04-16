package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112 {
	static int D, W, K;
	static int[][] map, originalMap;
	static int[] treatLine, treatType;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			originalMap = new int[D][W];
			for(int d = 0 ; d<D ; d++) {
				st = new StringTokenizer(br.readLine());
				for(int w = 0 ; w<W ; w++) {
					map[d][w] = Integer.parseInt(st.nextToken());
					originalMap[d][w] = map[d][w];
				}
			}
			
			// 모든 열이 합격기준을 만족하는지 체크해보기 -> 합격하면 바로 0 출력
			if(checkMap()) System.out.println("#" + test + " 0");
			
			// 합격하지 않는다면 
			else {
				// 1~D개의 조합 구성하기 dCn
				for(int d = 1 ; d<=D ; d++) {
					treatLine = new int[d];
					treatType = new int[d];
					if(makeSet(0, 0, d)) {
						System.out.println("#" + test + " " + d);
						break;
					}
				}
			}
		}
	}

	private static boolean makeSet(int idx, int start, int end) {
		if(idx == end) {
			// 조합의 요소에 해당하는 행들을 특성 A, B로 구분시켜주기 위해 다시 한번 순열을 구한다.
			if(selectAB(0, end)) return true;
//			System.out.println(Arrays.toString(treatLine));
			return false;
		}
		for(int i = start ; i<D ; i++) {
			treatLine[idx] = i;
			if(makeSet(idx+1, i+1, end)) return true;
		}
		return false;
	}

	private static boolean selectAB(int idx, int end) {
		if(idx == end) {
//			System.out.println(Arrays.toString(treatType));
			// 각 행에 특성을 Arrays.fill로 채워주기
			for(int i = 0 ; i<end ; i++) {
				Arrays.fill(map[treatLine[i]], treatType[i]);
			}
			
			// 합격기준 만족하는지 체크해보기
			boolean flag = checkMap();
			
			// 다시 원래 map으로 돌려놓기
			for(int d = 0 ; d<D ; d++) {
				map[d] = Arrays.copyOfRange(originalMap[d], 0, W);
			}
			
			return flag;
		}
		for(int i = 0 ; i<2 ; i++) { // 0이면 특성 A, 1이면 특성 B
			treatType[idx] = i;
			if(selectAB(idx+1, end)) return true;
		}
		return false;
	}

	private static boolean checkMap() {
		top:
		for(int w = 0 ; w<W ; w++) {
			int A = 0, B = 0;
			for(int d = 0 ; d<D ; d++) {
				if(map[d][w] == 0) {
					A++;
					B = 0;
				}
				else {
					A = 0;
					B++;
				}
				if(A == K || B == K) continue top;
			}
			return false;
		}
		return true;
	}

}
