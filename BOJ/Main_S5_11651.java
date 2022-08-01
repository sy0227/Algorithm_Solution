package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S5_11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[][] arr = new Integer[N][2];
		for(int n = 0 ; n<N ; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[1].equals(o2[1])) return o1[0]-o2[0];
				else return o1[1]-o2[1];
			}
		});
		for(int n = 0 ; n<N ; n++) {
			System.out.println(arr[n][0]+" "+arr[n][1]);
		}
	}

}
