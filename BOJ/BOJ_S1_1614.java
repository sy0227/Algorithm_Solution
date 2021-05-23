package boj;

import java.util.Scanner;

/**
 * 영식이의 손가락
 * 엄 검 중 약 새 약 중 검 / 엄~검 / ... 반복
 * 12345432 / 12345432
 * 1, 5는 한 번씩, 234는 두 번씩 반복
 * 
 * 일단 다친 손가락으로 셀 수 있는 횟수/(한 바퀴에 그 손가락으로 세는 횟수) * 8 해주기
 * 1) 그 이후로 엄지는 더 셀 수 없다
 * 2) 그 이후로 검지는 짝수면 1개만 더 세고, 홀수면 7개 더 셀 수 있음
 * 3) 중지는 짝수면 2개 더, 홀수면 6개 더
 * 4) 약지는 짝수면 3개 더, 홀수면 5개 더
 * 5) 새끼는 4개 더 셀 수 있다 
 */

public class BOJ_S1_1614 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int brokenFinger = sc.nextInt();
		long brokenCnt = sc.nextLong();
		
		long ans = 0;
		if(brokenFinger == 1 || brokenFinger == 5) ans = brokenCnt*8;
		else ans = brokenCnt/2*8;
		
		switch (brokenFinger) {
		case 1:
			break;
		case 2:
			ans += (brokenCnt%2 == 0)? 1 : 7;
			break;
		case 3:
			ans += (brokenCnt%2 == 0)? 2 : 6;
			break;
		case 4:
			ans += (brokenCnt%2 == 0)? 3 : 5;
			break;
		case 5:
			ans += 4;
			break;
		default:
			break;
		}
		System.out.println(ans);
		
		/** 원래 아이디어
		 * while문 반복하면서 손가락 번호를 list에 쭉 넣어주면서 다친손가락 몇 번 쓰는지 세주기.
		 * 그리고 다친 손가락 쓴 횟수가 가능한 횟수를 넘기면 그때 list 길이-1(다친손가락 한번 빼줘야됨) */
//		List<Integer> fingers = new LinkedList<Integer>();
//		int useFinger = 1, op = 1, cnt = 0;
//		while(true) {
//			if(cnt > brokenCnt) break;
//			fingers.add(useFinger);
//			if(useFinger == brokenFinger) cnt++;
//			
//			useFinger += op;
//			if(useFinger == 0) {
//				useFinger = 2;
//				op = 1;
//			}
//			if(useFinger == 6) {
//				useFinger = 4;
//				op = -1;
//			}
//		}
//		System.out.println(fingers.size()-1);
	}

}
