package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, W;
		int[] weights, profits;
		int[][] results;
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		weights = new int[N+1];
		profits = new int[N+1];
		results = new int[N+1][W+1];
		
		for(int i = 1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		int curr_w = 0, value = 0;
		for(int item = 1 ; item<=N ; item++) {
			curr_w = weights[item]; // 현 아이템의 무게
			value = profits[item]; // 현 아이템의 가치
			
			// 현 아이템을 1부터 W까지의 가치 테이블을 만들어보기
			for(int w = 1 ; w<=W ; w++) {
				if(curr_w<=w) { // 배낭에 현재 아이템을 담을 수 있다.
					// 							    이전 아이템의 가치		(배낭무게 w - 현재 아이템의 무게)가치 + 현재 아이템의 가치
					results[item][w] = Math.max(results[item-1][w], results[item-1][w-curr_w]+value);
				}
				else { // 배낭에 현재 아이템을 담을 수 없다
					// 이전 아이템의 가치를 담기
					results[item][w] = results[item-1][w];
				}
			}
		}
		
		System.out.println(results[N][W]);
	}

}
