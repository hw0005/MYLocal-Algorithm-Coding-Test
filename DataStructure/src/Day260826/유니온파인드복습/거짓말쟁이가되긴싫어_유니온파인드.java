package Day260826.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어_유니온파인드 {
	static int[] trueP;
	static ArrayList<Integer>[] party;
	static int[] parent;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수 
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		result = 0; // 정답용으로 세기
		
		// 1. 초기화 및 값 넣기
		
		// (1) 진실 아는 사람
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		trueP = new int[t];
		for (int i = 0; i < t; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}
		
		// (2) 파티 정보 담기
		party = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int partySize = Integer.parseInt(st.nextToken()); // 파티 참가 사람 수
			
			for (int j = 0; j < partySize; j++) {
				party[i].add(Integer.parseInt(st.nextToken())); // 번호 추가
			}
		}
		
		
		
		// (3) 자기 자신 parent 
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		
		// 2. 유니온 파인드
		
		// (1) parent와 party 유니온
		// 파티 수만큼 돌면서
		for (int i = 0; i < m; i++) {
			int firstPeople = party[i].get(0);
			// 각 파티의 사람 수 사이즈를 union한다.
			for (int j = 0; j < party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		// (2) 유니온한 것과 알고있는 사람 사이 find
		for (int i = 0; i < m; i++) {
			boolean isPossible = true; // 거짓말 가능?
			int cur = party[i].get(0);
			
			for (int j = 0; j < trueP.length; j++) {
				if (find(trueP[j]) == find(cur)) { // 있네? 거짓말 불능
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
	
	private static int find (int idx) {
		if (idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}

}
