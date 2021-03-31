package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_S5_2628 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		List<Integer> row = new LinkedList<Integer>();
		List<Integer> col = new LinkedList<Integer>();
		row.add(R);
		row.add(0);
		col.add(C);
		col.add(0);
		for(int n = 0 ; n<N ; n++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int line = Integer.parseInt(st.nextToken());
			if(op == 0) col.add(line);
			else if(op == 1) row.add(line);
		}
		Collections.sort(row);
		Collections.sort(col);
		
		int max_r = 0, max_c = 0;
		for(int i = 0, size = row.size() ; i<size-1 ; i++) {
			max_r = Math.max(max_r, row.get(i+1)-row.get(i));
		}
		for(int i = 0, size = col.size() ; i<size-1 ; i++) {
			max_c = Math.max(max_c, col.get(i+1)-col.get(i));
		}
		System.out.println(max_r*max_c);
	}

}
