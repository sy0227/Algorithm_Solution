package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17471 {
	static int N, ans;
	static int[] people;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> areaA, areaB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		people = new int[N+1];
		list = new ArrayList[N+1];
		areaA = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int n = 1 ; n<=N ; n++) {
			people[n] = Integer.parseInt(st.nextToken());
			list[n] = new ArrayList<Integer>();
		}
		for(int n = 1 ; n<=N ; n++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int c = 0 ; c<cnt ; c++) {
				list[n].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// N개의 구역을 두 집합으로 나누기 - 조합
		for(int i = 1 ; i<=N/2 ; i++) {
			comb(1, i);
		}
		
		ans = (ans == Integer.MAX_VALUE)? -1 : ans;
		System.out.println(ans);
	}

	private static void comb(int start, int R) {
		if(R == 0) {
			areaB = new ArrayList<Integer>();
			for(int i = 1 ; i<=N ; i++) {
				if(!areaA.contains(i)) areaB.add(i);
			}
			calcPeople();
			return;
		}
		for(int i = start ; i<=N ; i++) {
			areaA.add(i);
			comb(i+1, R-1);
			areaA.remove(areaA.size()-1);
		}
	}

	private static void calcPeople() {
		if(!isConnected(areaA.get(0), areaA)) return;
		if(!isConnected(areaB.get(0), areaB)) return;
		
		int peopleA = 0, peopleB = 0;
		for(int i = 0, size = areaA.size() ; i<size ; i++) {
			peopleA += people[areaA.get(i)];
		}
		for(int i = 0, size = areaB.size() ; i<size ; i++) {
			peopleB += people[areaB.get(i)];
		}
		
		int peopleNum = Math.abs(peopleA-peopleB);
		ans = Math.min(ans, peopleNum);
	}

	private static boolean isConnected(Integer idx, ArrayList<Integer> area) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		visited[idx] = true;
		
		int cnt = 1;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for (Integer i : list[temp]) {
				if(!visited[i] && area.contains(i)) {
					queue.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		if(cnt == area.size()) return true;
		return false;
	}


}
