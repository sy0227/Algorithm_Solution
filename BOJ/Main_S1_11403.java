package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_S1_11403 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		for(int n = 0 ; n<N ; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m<N ; m++) {
				graph[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0 ; k<N ; k++) {
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
				}
			}
		}
		
		for(int n = 0 ; n<N ; n++) {
			for(int m = 0 ; m<N ; m++) {
				System.out.print(graph[n][m]+" ");
			}
			System.out.println();
		}
	}

}
