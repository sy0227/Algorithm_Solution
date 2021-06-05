package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_S5_2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int max = 0;
		List<Integer> result = new LinkedList<Integer>();
		for(int i = num ; i>=num/2 ; i--) {
			List<Integer> list = new LinkedList<Integer>();
			list.add(num);
			int temp = num;
			int number = i;
			while(true) {
				if(temp<0) break;
				int t = temp;
				if(number>=0) list.add(number);
				temp = number;
				number = t-temp;
			}
			if(max<list.size()) {
				max = list.size();
				result = list;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Integer integer : result) {
			sb.append(integer+" ");
		}
		System.out.println(result.size());
		System.out.println(sb);
	}

}
