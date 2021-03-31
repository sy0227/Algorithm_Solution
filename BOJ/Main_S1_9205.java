package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S1_9205 {
	static boolean[][] isPossible;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			int N = Integer.parseInt(br.readLine());
			isPossible = new boolean[N+2][N+2];
			List<int[]> list = new ArrayList<int[]>();
			String ans = "happy";
			
			for(int i = 0 ; i<N+2 ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] {x, y});
			}
			
			for(int i = 0 ; i<N+2 ; i++) {
				for(int j = 0 ; j<N+2 ; j++) {
					int temp = Math.abs(list.get(i)[0]-list.get(j)[0])+Math.abs(list.get(i)[1]-list.get(j)[1]);
					if(temp <= 1000) isPossible[i][j] = true;
				}
			}
			
			for(int k = 0 ; k<N+2 ; k++) {
				for(int i = 0 ; i<N+2 ; i++) {
					for(int j = 0 ; j<N+2 ; j++) {
						if(isPossible[i][k] && isPossible[k][j]) isPossible[i][j] = true;
					}
				}
			}
			
			if(!isPossible[0][N+1]) ans = "sad";
			System.out.println(ans);
		}
	}

}
