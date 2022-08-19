package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tree = new int[N];
		int min = 0, max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n<N ; n++) {
			tree[n] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[n]);
		}
		while(min<max) {
			int mid = (min+max)/2;
			long sum = 0;
			for(int n = 0 ; n<N ; n++) {
				if(tree[n]-mid > 0) sum += (tree[n]-mid);
			}
			if(sum<M) max = mid;
			else min = mid+1;
		}
		System.out.println(min-1);
	}
}
