package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_G3_2533 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N-1][2];
		LinkedList<Integer>[] list = new LinkedList[N-1];
		
		for(int n = 0 ; n<N-1 ; n++) {
			list[n] = new LinkedList<Integer>();
		}
		
		for(int n = 0 ; n<N-1 ; n++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].offer(v);
			list[v].offer(u);
		}
	}

}
