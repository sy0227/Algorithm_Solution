package boj;

/**
 * 01타일
 * N=1, 1												1개
 * N=2, 00 11											2개
 * N=3, 001 100 111										3개
 * N=4, 0011 1001 1100 1111 0000						5개
 * N=5, 00001 00100 10000 11100 11001 10011 00111 11111	8개
 * 	=> 예를 들어 N=4일 때, N=2인 경우에서 00을 붙여주고 N=3에서 1을 붙인 경우로 정리할 수 있다.
 * 	=> arr[n] = arr[n-1] + arr[n-2] => 피보나치
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_S3_1940 {
	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        if(N<3) {
        	System.out.println(N);
        	return;
        }
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
    	for(int n = 3; n<=N; n++){
    		arr[n] = (arr[n-1]+arr[n-2]);
    		arr[n] %= 15746;
    	}
        System.out.println(arr[N]);
	}
}
