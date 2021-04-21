package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_5643 {
	static int N, M;
	static ArrayList<Integer>[] taller, smaller;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ;test++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			taller = new ArrayList[N+1];
			smaller = new ArrayList[N+1];
			for(int n = 0 ; n<=N ; n++) {
				taller[n] = new ArrayList<Integer>();
				smaller[n] = new ArrayList<Integer>();
			}
			
			for(int m = 0 ; m<M ; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a<b이므로 taller[a]에 b 넣기, smaller[b]에 a 넣기
				taller[a].add(b);
				smaller[b].add(a);
			}
			
			// N만큼 BFS 탐색해보면서 (자기보다 큰 학생들+자기보다 작은 학생들)이 N-1(본인 제외 모두)가 된다면 파악 가능하다는 의미
			int ans = 0;
			for(int n = 1 ; n<=N ; n++) {
				if(SmallerAndTallerCnt(n, taller) + SmallerAndTallerCnt(n, smaller) == N-1) ans++;
			}
			System.out.println("#"+test+" "+ans);
		}
	}

	private static int SmallerAndTallerCnt(int num, ArrayList<Integer>[] arr) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(num);
		visited[num] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i = 0 ; i<arr[temp].size() ; i++) {
				int next = arr[temp].get(i);
				if(!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}

//1
//6
//6
//1 5
//3 4
//5 4
//4 2
//4 6
//5 2