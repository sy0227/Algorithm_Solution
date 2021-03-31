package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_11758 {
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		Point[] point = new Point[3];
		
		for(int i = 0 ; i<3 ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point[i] = new Point(x, y);
		}
		
		int op1 = point[0].x*point[1].y + point[1].x*point[2].y + point[2].x*point[0].y;
		int op2 = point[1].x*point[0].y + point[2].x*point[1].y + point[0].x*point[2].y;
		int result = op1-op2;
		
		if(result > 0) System.out.println("1");
		else if(result == 0) System.out.println("0");
		else if(result < 0) System.out.println("-1");
		
	}

}
