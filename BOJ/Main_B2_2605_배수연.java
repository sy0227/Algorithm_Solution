package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_B2_2605_배수연 {
	static int[] students;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int N = sc.nextInt();
		students = new int[N];
		input = new int[N];
		for(int n = 0 ; n<N ; n++) {
			input[n] = sc.nextInt();
		}
		list.add(1);
		for(int i = 2 ; i<=N ; i++) {
			list.add(input[i-1], i);
		}
		for(int i = list.size()-1 ; i>=0 ; i--) {
			System.out.print(list.get(i)+" ");
		}
	}

}

// 0 1 1 3 2
// => 4 2 5 3 1