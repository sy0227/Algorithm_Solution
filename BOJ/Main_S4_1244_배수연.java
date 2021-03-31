package boj;

import java.util.Scanner;

public class Main_S4_1244_배수연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int switch_num = sc.nextInt();
		int[] button = new int[switch_num];
		for(int i = 0 ; i<switch_num ; i++) {
			button[i] = sc.nextInt();
		}
		
		int student_num = sc.nextInt();
		for(int i = 0 ; i<student_num ; i++) {
			int gender = sc.nextInt();
			int index = sc.nextInt();
			
			if(gender == 1) { // Male
				for(int j = index-1 ; j<switch_num ; j += index) {
					button[j] = 1-button[j]; // 0이면 1, 1이면 0
				}
			}
			
			else if(gender == 2) { // Female
				button[index-1] = 1-button[index-1];
				for(int left = index-2, right = index ; (left>=0 && right<switch_num && button[left] == button[right]) ; left--, right++) {
					button[left] = 1-button[left];
					button[right] = 1-button[right];
				}
			}
		}
		for(int i = 0 ; i < switch_num ; i++) {
	        System.out.print(button[i] + " ");
	        if((i+1) % 20 == 0) { //한 줄에 20개씩 출력
	            System.out.println();
	        }
	    }
	}
}


// input
//8
//0 1 0 1 0 0 0 1
//2
//1 3
//2 3

//output
//1 0 0 0 1 1 0 1