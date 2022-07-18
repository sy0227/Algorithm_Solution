package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_2740 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Integer[][] arrA = new Integer[N][M];
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m<M ; m++) {
				arrA[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		Integer[][] arrB = new Integer[M][K];
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 0 ; k<K ; k++) {
				arrB[m][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		Integer[][] answer = new Integer[N][K];
		for(int n = 0 ; n<N ; n++) {
			Arrays.fill(answer[n], 0);
		}
		
		for(int n = 0 ; n<N ; n++) {
			for(int k = 0 ; k<K ; k++) {
				for(int m = 0 ; m<M ; m++) {
					answer[n][k] += arrA[n][m] * arrB[m][k];
				}
			}
		}
		
		for(int n = 0 ; n<N ; n++) {
			for(int k = 0 ; k<K ; k++) {
				System.out.print(answer[n][k]+" ");
			}
			System.out.println();
		}
	}

}
