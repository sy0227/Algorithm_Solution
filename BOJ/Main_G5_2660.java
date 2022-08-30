package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_2660 {
	static final int INF = 987654321; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] friends = new int[N+1][N+1];
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				if(i != j) friends[i][j] = INF;
			}
		}
		String line;
		while(!(line = br.readLine()).equals("-1 -1")) {
			StringTokenizer st = new StringTokenizer(line);
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			friends[x][y] = friends[y][x] = 1;
		}
		
		for(int k = 0 ; k<N ; k++) {
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					friends[i][j] = Math.min(friends[i][j], friends[i][k]+friends[k][j]);
				}
			}
		}
		int min = INF;
		int[] scoreArr = new int[N];
		for(int i = 0 ; i<N ; i++) {
			int status = 0;
			for(int j = 0 ; j<N ; j++) {
				status = Math.max(status, friends[i][j]);
			}
			scoreArr[i] = status;
			min = Math.min(min, status);
		}
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<N ; i++) {
			if(scoreArr[i] == min) {
				cnt++;
				sb.append((i+1)+" ");
			}
		}
		System.out.println(min+" "+cnt);
		System.out.println(sb.toString());
	}

}
