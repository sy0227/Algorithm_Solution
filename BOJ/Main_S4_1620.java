package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_1620 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> mapIntkey = new HashMap<>();
		HashMap<String, Integer> mapStrkey = new HashMap<>();
		mapIntkey.put(0, "dummy");
		mapStrkey.put("dummy", 0);
		for(int n = 1 ; n<=N ; n++) {
			String pocketmon = br.readLine();
			mapIntkey.put(n, pocketmon);
			mapStrkey.put(pocketmon, n);
		}
		for(int m = 0 ; m<M ; m++) {
			String input = br.readLine();
			if(input.charAt(0) >= '0' && input.charAt(0)<='9') {
				System.out.println(mapIntkey.get(Integer.parseInt(input)));
			}
			else System.out.println(mapStrkey.get(input));
		}
	}

}
