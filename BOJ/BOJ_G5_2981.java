package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 검문
 * idea1) 잘못된 생각
 * 입력을 정렬해서 가장 작은 수를 구한다
 * 그 수에 대해서 1~작은 수를 다 나눠보고 나머지 다 기록해두기
 * 다른 수들도 1~작은 수로 나눠보면서 나머지 값이 다르면 그때의 m 제거하기
 * 
 * idea2)
 * A%p=B%p, B%p=C%p
 * => (A-B)%p=(B-C)%p
 * 인접한 항끼리 뺀 값에 대하여 최대공약수 갱신하며 구하기
 * 전체에 대한 최대공약수를 구하면 그 최대공약수의 약수 출력
 */

public class BOJ_G5_2981 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int n = 0 ; n<N ; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int gcd = arr[1]-arr[0];
		for(int n = 1 ; n<N-1 ; n++) {
			gcd = getGCD(gcd, arr[n+1]-arr[n]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2 ; i<=gcd ; i++) {
			if(gcd%i == 0) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
		
//		int small = arr[0];
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for(int i = 2 ; i<small ; i++) {
//			map.put(i, arr[0]%i);
//		}
//		
//		for(int n = 1 ; n<N ; n++) {
//			for(int i = 2 ; i<small ; i++) {
//				if(map.containsKey(i) && arr[n]%i != map.get(i)) map.remove(i);
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (Integer integer : map.keySet()) {
//			sb.append(integer+" ");
//		}
//		System.out.println(sb);
	}
	public static int getGCD(int a, int b) {
		if(a%b == 0) return b;
		else return getGCD(b, a%b);
	}
}

/*
3
6
36
216
* 2 3 5 6 10 15 30 */

