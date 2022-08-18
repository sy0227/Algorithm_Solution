package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 0 ; test<T ; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			System.out.println(solve(x1, y1, r1, x2, y2, r2));
		}
	}

	private static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
		int distance = (int)(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		if(x1 == x2 && y1 == y2 && r1 == r2) return -1; // 같은 원
		else if(distance>Math.pow(r1+r2, 2)) return 0; // 밖에 있고 만나지 않음
		else if(distance<Math.pow(r2-r1, 2)) return 0; // 안쪽에 있지만 만나지 않음
		else if(distance == Math.pow(r2-r1, 2)) return 1; // 내접
		else if(distance == Math.pow(r1+r2, 2)) return 1; // 외접
		else return 2;
	}
}
