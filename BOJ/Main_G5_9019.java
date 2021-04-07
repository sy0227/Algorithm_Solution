package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_9019 {
	static String[] dslr = {"D", "S", "L", "R"};
	
	static class Num{
		int num;
		String op;
		public Num(int num, String op) {
			super();
			this.num = num;
			this.op = op;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[10001];
			Queue<Num> queue = new LinkedList<Num>();
			queue.offer(new Num(A, ""));
			visited[A] = true;
			
			while(!queue.isEmpty()) {
				Num temp = queue.poll();
				if(temp.num == B) {
					System.out.println(temp.op);
					break;
				}
				
				for(int i = 0 ; i<4 ; i++) {
					int next = temp.num;
					switch (i) {
					case 0:
						next = (temp.num*2)%10000;
						break;
					case 1:
						next = (temp.num == 0)? 9999 : temp.num-1;
						break;
					case 2:
						next = temp.num/1000 + (temp.num%1000)*10;
						break;
					case 3:
						next = temp.num/10 + (temp.num%10)*1000;
						break;
					default:
						break;
					}
					if(!visited[next]) {
						visited[next] = true;
						queue.offer(new Num(next, temp.op+dslr[i]));
					}
					
				}
			}
			
		}
	}

}
