package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main_S4_1302 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int n = 0 ; n<N ; n++) {
			String book = br.readLine();
			if(map.containsKey(book)) map.replace(book, map.get(book)+1);
			else map.put(book, 1);
		}
		
		int max = 0;
		List<String> sortList = new ArrayList<String>();
		for (String temp : map.keySet()) {
			sortList.add(temp);
			max = Math.max(max, map.get(temp));
		}
		Collections.sort(sortList);
		for (String temp : sortList) {
			if(map.get(temp) == max) {
				System.out.println(temp);
				break;
			}
		}
		
	}

}
