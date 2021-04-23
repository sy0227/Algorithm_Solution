package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_15787 {
	static int op, trainNo, seatNo;
	static boolean[] visited = new boolean[1<<21];
	static int[] train;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		train = new int[N+1];
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			op = Integer.parseInt(st.nextToken());
			trainNo = Integer.parseInt(st.nextToken());
			if(op == 1 || op == 2) {
				seatNo = Integer.parseInt(st.nextToken());
			}
			
			if(op == 1) {
				// (1<<seatNo)자리를 | 1 처리
				train[trainNo] = train[trainNo] | (1<<seatNo);
			}
			else if(op == 2) {
				// (1<<seatNo)자리만 0으로 하고 &처리
				train[trainNo] = train[trainNo] & ~(1<<seatNo);
			}
			else if(op == 3) {
				// 전부 << 1, 21번째에 자리하게 된 사람은 & 0 처리
				train[trainNo] = train[trainNo] << 1;
				train[trainNo] &= ~(1<<21);
			}
			else if(op == 4) {
				// 전부 >> 1, 첫 번째에 자리하게 된 사람은 & ~1 처리
				train[trainNo] = train[trainNo] >> 1;
				train[trainNo] &= ~1;
			}
		}
		
		int ans = 0;
		for(int n = 1 ; n<=N ; n++) {
			if(!visited[train[n]]) ans++;
			visited[train[n]] = true;
		}
		System.out.println(ans);
	}
}
