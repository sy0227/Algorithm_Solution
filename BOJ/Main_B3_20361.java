package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_20361 {
	static int T, N, X, K, A, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		X = Integer.parseInt(st1.nextToken());
		K = Integer.parseInt(st1.nextToken());
		int[] cups = new int[N+1];
		for (int i = 1; i <= N; i++) {
			cups[i] = i;
		}
		for(int k = 0 ; k<K ; k++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st2.nextToken());
			B = Integer.parseInt(st2.nextToken());
			int temp = -1;
			temp = cups[A]; 
			cups[A] = cups[B]; 
			cups[B] = temp; 
		}
		for(int i = 1 ; i<=N ; i++) {
			if(cups[i] == X) { 
				System.out.println(i);
			}
		}
	}

}
