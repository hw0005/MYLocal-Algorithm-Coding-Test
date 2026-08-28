package Day260828.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어 {
	static int[] parent;
	static int[] trueP;
	static ArrayList<Integer>[] party;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		int result = 0;
		
		//초기화
		parent = new int[n + 1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
		trueP = new int[t + 1];
		
		for (int i=1; i<=t; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}
		
		party = new ArrayList[m + 1];
		for (int i = 1; i<=m; i++) {
			party[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int partySize = Integer.parseInt(st.nextToken());
			
			for (int j=1; j<=partySize; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// party와 parent union
		for (int i = 1; i<=m; i++) {
			int firstPeople = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		// party와 trueP find
		for (int i = 1; i <=m; i++) {
			boolean isPossible = true;
			int currentPeople = party[i].get(0);
			
			for (int j = 1; j<=t; j++) {
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
