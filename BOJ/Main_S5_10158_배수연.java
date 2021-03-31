package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_10158_배수연 {
	static int W, H, x, y, time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(br.readLine());
		
		int new_x, new_y, ans_x, ans_y;
		new_x = (x+time)%(2*W);
		ans_x = W-Math.abs(W-new_x);
		
		new_y = (y+time)%(2*H);
		ans_y = H-Math.abs(H-new_y);
		
		sb.append(ans_x).append(" ").append(ans_y);
		
		System.out.println(sb.toString());
	}

}
