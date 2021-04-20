package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S4_1021 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for(int m = 0 ; m<M ; m++) {
			arr[m] = Integer.parseInt(st.nextToken())-1;
		}
		
		List<Integer> list = new LinkedList<Integer>();
		int ans = 0;
		for(int n = 0 ; n<N ; n++) {
			list.add(n);
		}
		for(int m = 0 ; m<M ; m++) {
			int idx = list.indexOf(arr[m]);
			if(idx<list.size()-idx) {
				for(int i = 0 ; i<idx ; i++) {
					list.add(list.remove(0));
					ans++;
				}
			}
			else {
				for(int i = 0 ; i<list.size()-idx ; i++) {
					list.add(0, list.remove(list.size()-1));
					ans++;
				}
			}
			list.remove(0);
		}
		System.out.println(ans);
	}

}
