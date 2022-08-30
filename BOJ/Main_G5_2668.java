package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_G5_2668 {
	static ArrayList<Integer> list;
	static boolean[] visited;
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visited = new boolean[N+1];
		num = new int[N+1];
		for(int n = 0 ; n<N ; n++) {
			num[n+1] = Integer.parseInt(br.readLine());
		}
		for(int n = 1 ; n<=N ; n++) {
			visited[n] = true;
			DFS(n, n);
			visited[n] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0, size = list.size() ; i<size ; i++) {
			System.out.println(list.get(i));
		}
	}

	private static void DFS(int start, int end) {
		if(visited[num[start]] == false) {
			visited[num[start]] = true;
			DFS(num[start], end);
			visited[num[start]] = false;
		}
		if(num[start] == end) list.add(end);
	}
}