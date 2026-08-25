package Day260825.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말_유니온파인드 {
	static ArrayList<Integer>[] party;
	static int[] parent;
	static int[] trueP;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 전체 사람 수
		int m = Integer.parseInt(st.nextToken()); // 전체 파티 수

		// trueP초기화
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); // 진실 아는 사람 수
		trueP = new int[t];
		for (int i = 0; i < t; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}
		
		// party, parent 초기화
		party = new ArrayList[m];
		parent = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int howManyPeople = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= howManyPeople; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		// party와 parent 유니온
		for (int i = 0; i < m; i++) {
			int firstPeople = party[i].get(0);
			for (int j = 0; j < party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		// party와 parent 유니온 한 것을 아는 사람 trueP와 파인드
		// party 돌고
		result = 0;
		for (int i = 0; i < m; i++) {
			boolean isPossible = true;
			int cur = party[i].get(0); // 처음 파티의 처음 사람이 꺼내오기
			//trueP돌고
			for (int j = 0; j < trueP.length; j++) {
				if (find(cur) == find(trueP[j])) { // 만약 파티에서 꺼내온 사람과 알고있는 사람이 같다면
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
