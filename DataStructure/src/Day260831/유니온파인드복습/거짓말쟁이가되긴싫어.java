package Day260831.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어 {
	static ArrayList<Integer>[] party;
	static int[] parent;
	static int[] trueP;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); // 진실 아는 사람 수
		trueP = new int[t + 1];
		for (int i = 1; i <= t; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		
		party = new ArrayList[m + 1];
		for (int i = 1; i <= m; i++) {
			party[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int partySize = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= partySize; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//------------------------초기화 끝
		
		// 1. union -> party, parent
		
		for (int i = 1; i <= m; i++) {
			int eachPartyFirstPeople = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				union (eachPartyFirstPeople, party[i].get(j));
			}
		}
		
		
		
		// 2. parent에서 trueP찾기
		int result = 0;
		
		for (int i = 1; i <= m; i++) {
			boolean isPossible = true;
			int eachPartyFirstPeoeple = party[i].get(0);
			
			for (int j = 1; j <= t; j++) {
				if (find(eachPartyFirstPeoeple) == find(trueP[j])) {
					isPossible = false;
					break;
				}
  			}
			
			if (isPossible) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;
		}
	}
	
	private static int find(int idx) {
		if (idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}

}
