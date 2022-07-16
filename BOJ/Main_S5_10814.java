package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main_S5_10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for(int n = 0 ; n<N ; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[n][0] = st.nextToken();
			arr[n][1] = st.nextToken();
		}
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
			}
		});
		
		for(int n = 0 ; n<N ; n++) {
			System.out.println(arr[n][0]+" "+arr[n][1]);
		}
	}

}
