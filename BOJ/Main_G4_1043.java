package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_1043 {
	static int N, M, ans;
	static boolean[] secret;
	static boolean[][] connected;
	static int[][] party;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수
		secret = new boolean[N+1];
		connected = new boolean[N+1][N+1];
		party = new int[M][];
		
		st = new StringTokenizer(br.readLine());
		int knowSecret = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		if(knowSecret == 0) {
			System.out.println(M);
			return;
		}
		for(int s = 0 ; s<knowSecret ; s++) { // 진실을 아는 사람 명단
			secret[Integer.parseInt(st.nextToken())] = true;
		}
		
		for(int m = 0 ; m<M ; m++) { // 파티마다 오는 사람들 수, 명단
			st = new StringTokenizer(br.readLine());
			int partyPeople = Integer.parseInt(st.nextToken());
			party[m] = new int[partyPeople];
			party[m][0] = Integer.parseInt(st.nextToken());
			for(int p = 1 ; p<partyPeople ; p++) {
				party[m][p] = Integer.parseInt(st.nextToken());
				connected[party[m][p-1]][party[m][p]] = true;
				connected[party[m][p]][party[m][p-1]] = true;
			}
		}
		for(int n = 1 ; n<=N ; n++) {
			if(secret[n]) DFS(n);
		}
		
		ans = 0;
		for(int m = 0 ; m<M ; m++) {
			if(!secret[party[m][0]]) ans++;
		}
		System.out.println(ans);
		
	}

	private static void DFS(int n) {
		for(int i = 1 ; i<=N ; i++) {
			if(connected[n][i] && !secret[i]) {
				secret[i] = true;
				DFS(i);
			}
		}
	}

}
