package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_10815 {
	static StringBuilder sb;
	static int[] arrN;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arrN = new int[N];
		for(int n = 0 ; n<N ; n++) {
			arrN[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int m = 0 ; m<M ; m++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(isExist(num)+" ");
		}
		System.out.println(sb.toString());
		
	}

	private static int isExist(int num) {
		int left = 0, right = arrN.length-1, mid = 0;
		while(left <= right) {
			mid = (left+right)/2;
			if(arrN[mid] == num) return 1;
			if(arrN[mid]<num) left = mid+1;
			else right = mid-1;
		}
		return 0;
	}
}
