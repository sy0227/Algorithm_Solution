package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_20299 {
	static int N, S, M;
	static int[] student = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken()); 
		S = Integer.parseInt(st1.nextToken()); 
		M = Integer.parseInt(st1.nextToken()); 
		int cnt = 0;
		
		for(int test = 0 ; test<N ; test++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
//			int sum = 0;
//			for(int i = 0 ; i<3 ; i++) {
//				student[i] = Integer.parseInt(st2.nextToken());
//				if(student[i] < M) break;
//				sum += student[i];
//			}
//			if(sum >= S) {
//				cnt++;
//				sb.append(student[0] + " " + student[1] + " " + student[2] + " "); 
//			}
			int student1 = Integer.parseInt(st2.nextToken());
			int student2 = Integer.parseInt(st2.nextToken());
			int student3 = Integer.parseInt(st2.nextToken());
			int sum = student1+student2+student3;
			if(student1>=M && student2>=M && student3>=M && sum >= S) {
				cnt++;
				sb.append(student1 + " " + student2 + " " + student3 + " ");
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString().trim());
	}

}
