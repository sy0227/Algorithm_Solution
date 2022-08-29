package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Grade implements Comparable<Grade>{
	int a, b;
	Grade(int a, int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Grade o) {
		if(this.a>o.a) return 1;
		else return -1;
	}
}
public class Main_S1_1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 0 ; test<T ; test++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Grade> list = new ArrayList<Grade>();
			for(int n = 0 ; n<N ; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list);
			int answer = 1;
			int min = list.get(0).b;
			for(int n = 1 ; n<N ; n++) {
				if(list.get(n).b < min) {
					answer ++;
					min = list.get(n).b;
				}
			}
			System.out.println(answer);
		}
	}
}
