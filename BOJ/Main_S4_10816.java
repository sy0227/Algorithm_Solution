package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arrN = new int[20000001];
		for(int n = 0 ; n<N ; n++) {
			arrN[Integer.parseInt(st.nextToken())+10000000]++;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int m = 0 ; m<M ; m++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(arrN[num+10000000]+" ");
		}
		System.out.println(sb.toString());
	}
}
