package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_1525 {
	static int from_x, from_y, ans;
	static int[][] map = new int[3][3];
	static String start;
	static final String answer = "123456780";
	static HashMap<String, Integer> visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Str {
		String name;
		int cnt;
		public Str(String name, int cnt) {
			super();
			this.name = name;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visited = new HashMap<String, Integer>();
		start = "";
		for(int i = 0 ; i<3 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<3 ; j++) {
				start += st.nextToken();
			}
		}
//		System.out.println(start);
		BFS();
		System.out.println(ans);
	}

	private static void BFS() {
		ans = -1;
		Queue<Str> queue = new LinkedList<Str>();
		queue.offer(new Str(start, 0));
		visited.put(start, 0);
		while(!queue.isEmpty()) {
			Str temp = queue.poll();
			String temp_str = temp.name;
			int temp_cnt = temp.cnt;
			if(temp_str.equals(answer)) {
				ans = temp_cnt;
				return;
			}
			
			int zeroIdx = temp_str.indexOf("0");
			int zero_x = zeroIdx/3;
			int zero_y = zeroIdx%3;
			
			int nr = 0, nc = 0;
			for(int d = 0 ; d<4 ; d++) {
				nr = zero_x+dr[d];
				nc = zero_y+dc[d];
				if(nr>-1 && nr<3 && nc>-1 && nc<3) {
					StringBuilder next_str = new StringBuilder(temp_str);
					char tmp = next_str.charAt(nr*3+nc);
					next_str.setCharAt(nr*3+nc, '0');
					next_str.setCharAt(zeroIdx, tmp);
					
					String next = next_str.toString();
					if(!visited.containsKey(next)) {
						visited.put(next, temp_cnt+1);
						queue.offer(new Str(next, temp_cnt+1));
					}
				}
			}
		}
	}

}
