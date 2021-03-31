package boj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_S4_10866 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deque = new LinkedList<Integer>();
		int N = sc.nextInt();
		for(int i=0; i < N; i++) {
            String op = sc.next();
            if(op.equals("push_back")) {
                int b = sc.nextInt();
                deque.addLast(b);
            }else if(op.equals("push_front")) {
                int b = sc.nextInt();
                deque.addFirst(b);
            }else if(op.equals("pop_front")) {
                System.out.println(deque.isEmpty()? -1 : deque.pollFirst());
            }else if(op.equals("pop_back")) {
                System.out.println(deque.isEmpty()?-1:deque.pollLast());
            }else if(op.equals("size")) {
                System.out.println(deque.size());
            }else if(op.equals("empty")) {
                System.out.println(deque.isEmpty()?1:0);
            }else if(op.equals("front")) {
                System.out.println(deque.isEmpty()?-1:deque.peekFirst());
            }else if(op.equals("back")) {
                System.out.println(deque.isEmpty()?-1:deque.peekLast());
            }
        }
	}

}
