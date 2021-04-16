package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_G2_4195 {
	static int F;
	static int[] parents, size;
	
	static void make() {
		for(int n = 0 ; n<=F*2 ; n++) {
			parents[n] = n;
			size[n] = 1;
		}
	}
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	static int union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA != rootB) {
			parents[rootB] = rootA;
			size[rootA] += size[rootB];
		}
		return size[rootA];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			F = Integer.parseInt(br.readLine());
			parents = new int[F*2+1];
			size = new int[F*2+1];
			HashMap<String, Integer> friendMap = new HashMap<String, Integer>();
			make();
			int index = 1;
			for(int f = 0 ; f<F ; f++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(!friendMap.containsKey(a)) friendMap.put(a, index++);
				if(!friendMap.containsKey(b)) friendMap.put(b, index++);
				
				int ans = union(friendMap.get(a), friendMap.get(b));
				sb.append(ans+"\n");
			}
		}
		System.out.print(sb.toString());
	}

}
