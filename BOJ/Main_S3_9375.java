package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S3_9375 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 0 ; test<T ; test++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for(int n = 0 ; n<N ; n++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				if(map.containsKey(kind)) map.put(kind, map.get(kind)+1);
				else map.put(kind, 1);
			}
			int ans = 1;
			for (int val : map.values()) {
				ans *= (val+1);
			}
			System.out.println(ans-1);
		}
	}

}
