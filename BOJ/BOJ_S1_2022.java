package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리
 * x^2 = ans^2+leftH^2
 * y^2 = ans^2+rightH^2
 * a:ans = c:rightH -> a*rightH = ans*c -> a = ans*c/rightH
 * b:ans = c:leftH -> b*leftH = ans*c -> b = ans*c/leftH
 * ans = a+b = ans*c/rightH+ans*c/leftH
 * 1 = c/rightH+c/leftH = c*(rightH+leftH)/rightH*leftH
 * c = rightH*leftH/(rightH+leftH)
 * 
 * => left=0, right=(x, y중 최대)로 설정하고, 둘의 차이가 0.000001보다 큰 동안 반복하며 이분탐색
 * mid값으로 추정한 c값이 주어진 c보다 크거나 같으면 값 갱신
 */
public class BOJ_S1_2022 {
	static double x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		
		double left = 0, right = Math.max(x, y);
		double ans = 0;
		while(left+0.000001<right) {
			double mid = (left+right)/2;
			if(getC(mid) >= c) {
				ans = mid;
				left = mid+0.0001;
			}
			else right = mid-0.0001;
		}
		System.out.printf("%.3f", ans);
	}

	private static double getC(double mid) {
		double leftH = Math.sqrt(x*x-mid*mid);
		double rightH = Math.sqrt(y*y-mid*mid);
		return (rightH*leftH)/(rightH+leftH);
	}
}
