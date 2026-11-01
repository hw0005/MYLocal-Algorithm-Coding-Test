package 그래프.Day261101.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어 {
	static int[] parent;
	
	static int[] knowP; // 진실 아는 사람
	static ArrayList<Integer>[] party; // 파티에 참여하는 각 사람의 정보
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		parent = new int[n+1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		party = new ArrayList[m+1];
		for (int i=1; i<=m; i++) {
			party[i] = new ArrayList<>();
		}
		
		// 진실 아는 사람 수
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		knowP = new int[k+1];
		for (int i=1; i<=k; i++) {
			knowP[i] = Integer.parseInt(st.nextToken());
		}
		
		
		/// 파티 정보
		for (int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int request = Integer.parseInt(st.nextToken());
			for (int j=1; j<=request; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		/////////// 초기화 끝
		
		
		// 같은 파티에 속해있는 사람끼리 union
		for (int i=1; i<party.length; i++) {
			int firstPeople = party[i].get(0);
			for (int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		// 파티 돌면서 진실아는 사람 꺼내서 거기서 없다면 count++;
		int count = 0;
		
		for (int i=1; i<party.length; i++) {
			// 대표자 1명 == 그 파티에 참석한 사람들과 엮임
			int representitive = party[i].get(0);
			boolean isPossible = true; // 속이기 되는 게 기본 상태
			
			for (int j=1; j<knowP.length; j++) {
				if(find(representitive) == find(knowP[j])) { // 대표자와 아는 사람이 같으면 속이기 불가능
					isPossible = false; // 어 속이기 불가능해
					break;
				}
			}
			if(isPossible) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
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
