package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오등큰수 - 스택
 */

public class BOJ_G3_17299 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int[] F = new int[1000001]; // 각 수가 몇 번 나왔는지 저장할 배열
		int[] NGF = new int[N+1]; // 오등큰수 정답을 저장할 배열
		for(int n = 0 ; n<N ; n++) {
			int num = Integer.parseInt(st.nextToken());
			arr[n] = num;
			F[num]++;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int n = 0 ; n<N ; n++) {
			while(!stack.isEmpty() && F[arr[stack.peek()]]<F[arr[n]]) {
				NGF[stack.pop()] = arr[n];
			}
			stack.push(n);
		}
		while(!stack.isEmpty()) {
			NGF[stack.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int n = 0 ; n<N ; n++) {
			sb.append(NGF[n]+" ");
		}
		System.out.println(sb);
	}

}

/*
7
3 2 4 1 2 2 3

=> 
F : 2 3 1 1 3 3 2
NGF : 2 -1 2 2 -1 -1 -1
 */
