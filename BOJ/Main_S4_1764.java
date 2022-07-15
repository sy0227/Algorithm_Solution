package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S4_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> list = new HashSet<>();
		ArrayList<String> answer = new ArrayList<>();
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			list.add(st.nextToken());
		}
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			if(list.contains(name)) answer.add(name);
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i = 0 ; i<answer.size() ; i++) {
			System.out.println(answer.get(i));
		}
	}

}
