package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_16935 {
	static int N, M, R;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<R ; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			default:
				break;
			}
		}
		for(int i = 0 ; i<map.length ; i++) {
			for(int j = 0 ; j<map[i].length ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	static void one() {
		int num = map.length;
		for(int r = 0 ; r<num/2 ; r++) {
			int[] temp = map[r];
			map[r] = map[num-r-1];
			map[num-r-1] = temp;
		}
	}
	static void two() {
		int num1 = map.length;
		int num2 = map[0].length;
		for(int r = 0 ; r<num1 ; r++) {
			for(int c = 0 ; c<num2/2 ; c++) {
				int temp = map[r][c];
				map[r][c] = map[r][num2-c-1];
				map[r][num2-c-1] = temp;
			}
		}
	}
	static void three() {
		int[][] temp_map = map.clone();
		int num1 = map.length;
		int num2 = map[0].length;
		map = new int[num2][num1];
		for(int r = 0 ; r<num1 ; r++) {
			for(int c = 0 ; c<num2 ; c++) {
				map[c][num1-r-1] = temp_map[r][c];
			}
		}
	}
	static void four() {
		int[][] temp_map = map.clone();
		int num1 = map.length;
		int num2 = map[0].length;
		map = new int[num2][num1];
		for(int r = 0 ; r<num2 ; r++) {
			for(int c = 0 ; c<num1 ; c++) {
				map[r][c] = temp_map[c][num2-r-1];
			}
		}
	}
	static void five() {
		int num1 = map.length;
		int num2 = map[0].length;
		int[][] temp_map = new int[num1][num2];
		for(int i = 0 ; i<num1 ; i++) {
			System.arraycopy(map[i], 0, temp_map[i], 0, num2);
		}
		//1->2
		for(int r = 0 ; r<num1/2 ; r++) {
			for(int c = 0 ; c<num2/2 ; c++) {
				map[r][c+num2/2] = temp_map[r][c];
			}
		}
		//2->3
		for(int r = 0 ; r<num1/2 ; r++) {
			for(int c = num2/2 ; c<num2 ; c++) {
				map[r+num1/2][c] = temp_map[r][c];
			}
		}
		//3->4
		for(int r = num1/2 ; r<num1 ; r++) {
			for(int c = num2/2 ; c<num2 ; c++) {
				map[r][c-num2/2] = temp_map[r][c];
			}
		}
		//4->1
		for(int r = num1/2 ; r<num1 ; r++) {
			for(int c = 0 ; c<num2/2 ; c++) {
				map[r-num1/2][c] = temp_map[r][c];
			}
		}
	}
	static void six() {
		int num1 = map.length;
		int num2 = map[0].length;
		int[][] temp_map = new int[num1][num2];
		for(int i = 0 ; i<num1 ; i++) {
			System.arraycopy(map[i], 0, temp_map[i], 0, num2);
		}
		
		//1->4
		for(int r = 0 ; r<num1/2 ; r++) {
			for(int c = 0 ; c<num2/2 ; c++) {
				map[r+num1/2][c] = temp_map[r][c];
			}
		}
		//2->1
		for(int r = 0 ; r<num1/2 ; r++) {
			for(int c = num2/2 ; c<num2 ; c++) {
				map[r][c-num2/2] = temp_map[r][c];
			}
		}
		//3->2
		for(int r = num1/2 ; r<num1 ; r++) {
			for(int c = num2/2 ; c<num2 ; c++) {
				map[r-num1/2][c] = temp_map[r][c];
			}
		}
		//4->3
		for(int r = num1/2 ; r<num1 ; r++) {
			for(int c = 0 ; c<num2/2 ; c++) {
				map[r][c+num2/2] = temp_map[r][c];
			}
		}
	}

}
