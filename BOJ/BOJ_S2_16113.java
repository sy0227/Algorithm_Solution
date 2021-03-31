package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S2_16113 {
	static String zero = 	"######...######";
	static String one = 	"#####";
	static String two = 	"#.####.#.####.#";
	static String three = 	"#.#.##.#.######";
	static String four = 	"###....#..#####";
	static String five = 	"###.##.#.##.###";
	static String six = 	"######.#.##.###";
	static String seven = 	"#....#....#####";
	static String eight = 	"######.#.######";
	static String nine = 	"###.##.#.######";
	static String[] numbers = {
			"######...######",
			"#####",
			"#.####.#.####.#",
			"#.#.##.#.######",
			"###....#..#####",
			"###.##.#.##.###",
			"######.#.##.###",
			"#....#....#####",
			"######.#.######",
			"###.##.#.######"
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		char[][] map = new char[5][N/5];
		int k = 0;
		int len = N/5;
		for(int i = 0 ; i<5 ; i++) {
			for(int j = 0 ; j<len ; j++) {
				map[i][j] = line.charAt(k++);
			}
		}
		int[] col = new int[len]; // 공백 열들의 인덱스를 저장할 배열
		Arrays.fill(col, -1);
		int idx = 0;
		for(int i = 0 ; i<len ; i++) {
			boolean flag_col = true;
			for(int j = 0 ; j<5 ; j++) {
				if(map[j][i] != '.') flag_col = false;
			}
			if(flag_col) col[idx++] = i;
		}
		
		// N/5개의 열 중에서 col 배열에 해당하지 않은 열들을 탐색
		// col 배열에서 두 값 차이가 2인 경우는 1 => 1의 인덱스를 기억해주어야 함
		
		boolean[] col_blank_check = new boolean[len];
		int[] col_blank = new int[idx];
		int[] col_txt = new int[len-idx];
		int[] col_one = new int[len-idx];
		for(int i = 0, c = 0 ; i<len ; i++) {
			if(col[i] != -1) {
				col_blank[c++] = col[i];
			}
		}
		
		for(int i = 0 ; i<idx ; i++) {
			col_blank_check[col_blank[i]] = true;
		}
		for(int i = 0, c = 0 ; i<len ; i++) {
			if(!col_blank_check[i]) col_txt[c++] = i;
		}
		System.out.println(Arrays.toString(col_txt));
		
		int idx_one = 0;
		for(int i = 0 ; i<col_txt.length-1 ; i++) {
			if(col_txt[i+1]-col_txt[i] >= 2) {
				col_one[idx_one++] = col_txt[i+1];
			}
		}
		System.out.println(Arrays.toString(col_one));
		
		// String 하나 생성해서 공백이 아닌 부분들을 쭉 한줄로 엮어주기
		
		String str = "";
		for(int i = 0 ; i<col_txt.length ; i++) {
			for(int j = 0 ; j<5 ; j++) {
				str+=map[j][i];
			}
		}
//		for(int i = 0 ; i<idx ; i++) {
//			for(int j = 0 ; j<len ; j++) {
//				for(int z = 0 ; z<5 ; z++) {
//					
//				}
//			}
//		}
		
		
	}

}
