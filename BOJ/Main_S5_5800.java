package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_5800 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=K ; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			int[] score = new int[student];
			for(int i = 0 ; i<student ; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score);
			int gap = 0;
			for(int i = 0, size = score.length ; i<size-1 ; i++) {
				gap = Math.max(gap, score[i+1]-score[i]);
			}
			System.out.printf("Class %d\nMax %d, Min %d, Largest gap %d\n", test, score[score.length-1], score[0], gap);
		}
	}
}
