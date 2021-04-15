package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2577 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken())-1;
		int[] sushiBelt = new int[N];
		int[] eat = new int[D];
		int ans = 0;
		for(int n = 0 ; n<N ; n++) {
			sushiBelt[n] = Integer.parseInt(br.readLine())-1;
		}
		
		int cnt = 0;
		
		// C는 넣고 시작
		if(eat[C] == 0) cnt++;
		eat[C]++;
		
		// 처음 K개 배열에 넣어두기
		for(int k = 0 ; k<K ; k++) {
			if(eat[sushiBelt[k]] == 0) cnt++;
			eat[sushiBelt[k]]++;
		}
		
		// 한개씩 빼보고 새로 넣고 최대값 갱신
		for(int i = 0 ; i<N-1 ; i++) {
			eat[sushiBelt[i]]--;
			if(eat[sushiBelt[i]] == 0) cnt--;
			
			if(eat[sushiBelt[(i+K)%N]] == 0) cnt++;
			eat[sushiBelt[(i+K)%N]]++;
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}

}
