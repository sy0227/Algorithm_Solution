package boj;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_G4_1744 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		int[] arr = new int[N];
		List<Integer> minus = new LinkedList<>();
		List<Integer> plus = new LinkedList<>();
		long ans = 0;
		boolean zero = false;
		for(int n = 0 ; n<N ; n++) {
			int num = sc.nextInt();
			if(num>0) plus.add(num);
			else if(num<0) minus.add(num);
			else zero = true;
		}
		plus.sort(Comparator.reverseOrder());
		Collections.sort(minus);
		
		for(int i = 0 ; i<plus.size()-1 ; i+=2) {
			if(plus.get(i) == 1 || plus.get(i+1) == 1) ans += (plus.get(i)+plus.get(i+1));
			else ans += plus.get(i)*plus.get(i+1);
		}
		if(plus.size()%2 == 1) ans += plus.get(plus.size()-1);
		
		int minusSize;
		if(zero) {
			if(minus.size()%2 == 1) minusSize = minus.size()-1;
			else minusSize = minus.size();
		} else minusSize = minus.size();
		for(int i = 0 ; i<minusSize-1 ; i+=2) {
			ans += minus.get(i)*minus.get(i+1);
		}
		if(minusSize%2 == 1) ans += minus.get(minusSize-1);
		
		System.out.println(ans);
		
	}

}
