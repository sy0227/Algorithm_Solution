package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289 {
	static int N;
	static int[] numbers;
	
	static void make() {
		for(int n = 1 ; n<=N ; n++) {
			numbers[n] = n;
		}
	}
	
	static int findSet(int a) {
		if(numbers[a] == a) return a;
		return numbers[a] = findSet(numbers[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot != bRoot) numbers[bRoot] = aRoot;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			numbers = new int[N+1];
			make();
			sb.append("#"+test+" ");
			for(int m = 0 ; m<M ; m++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(op == 0) union(a, b);
				else {
					if(findSet(a) == findSet(b)) sb.append("1");
					else sb.append("0");
					
				}
			}
			System.out.println(sb.toString());
		}
	}

}

