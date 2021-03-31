package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S5_17478 {
	
	static String str1 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
	static String str2 = "\"재귀함수가 뭔가요?\"";
	static String[] recur_str = {
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
	};
	static String str3 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	static String str4 = "라고 답변하였지.";
	static int N;
	static int bar = 0; // ____를 반복할 횟수
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(str1);
		
		chat(N);
	}
	
	public static void chat(int n) {
		if (n == 0) { // 기저 조건 : str2+str3+str4
	        print_bar(bar);
	        System.out.println(str2);
	        print_bar(bar);
	        System.out.println(str3);
	        print_bar(bar);
	        System.out.println(str4);
	        bar--;
	        return;
	    }
		
		// str2 물어보는 것부터 recur_str[i] 답하는거 반복
		print_bar(bar);
		System.out.println(str2);
		
		for(int i = 0 ; i<recur_str.length ; i++) {
			print_bar(bar);
			System.out.println(recur_str[i]);
		}
	    bar++;
	    
	    chat(n-1);
	    
	    // 마지막에 ____랑 str4 반복하고 끝
	    print_bar(bar);
	    System.out.println(str4);
	    bar--;
		
	}
	
	public static void print_bar(int b) {
		for(int i = 0 ; i<b ; i++) {
			System.out.print("____");
		}
	}

}
