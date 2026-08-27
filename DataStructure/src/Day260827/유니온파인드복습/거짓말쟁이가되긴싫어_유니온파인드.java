package Day260827.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어_유니온파인드 {
	static ArrayList<Integer>[] party;
	static int[] trueP;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		
		// 초기화
		parent = new int[n + 1];
		for (int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken()); // 진실 을 아는 사람 수
		trueP = new int[k + 1];
		for (int i = 1; i <= k; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}
		
		
		party = new ArrayList[m + 1];
		for (int i = 1; i <= m; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int partySize = Integer.parseInt(st.nextToken()); // 파티 인원 수
			
			for (int j = 1; j <= partySize; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		///////------------------초기화끝------------/////////////
		
		// party + parent 합치기
		for (int i = 1; i <=m; i++) {
			int firstPeople = party[i].get(0);
			for (int j = 0; j < party[i].size(); j++) {
				union(party[i].get(j), firstPeople);
			}
		}
		
		int result = 0;
		// 합친 것과 tureP 검사
		for (int i = 1; i <= m; i++) {
			boolean isPossible = true;
			
			int currentPeople = party[i].get(0);
			
			for (int j = 0; j < trueP.length; j++) {
				if (find(currentPeople) == find(trueP[j])) {
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
	
	private static void union (int a, int b) {
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
