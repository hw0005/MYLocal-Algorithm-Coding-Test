package 그래프.Day261102.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어 {
	static int[] trueP;
	static ArrayList<Integer>[] partyInfo;
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		
		parent = new int[n+1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		
		// 진실아는 사람 수
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		trueP = new int[k+1];
		for (int i=1; i<=k; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 파티 정보
		partyInfo = new ArrayList[m+1];
		for (int i=1; i<=m; i++) {
			partyInfo[i] = new ArrayList<>();
		}
		
		for (int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken());
			for (int j=1; j<=people; j++) {
				partyInfo[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		//----------------------------------------------------
		for (int i=1; i<partyInfo.length; i++) {
			int firstPeople = partyInfo[i].get(0);
			
			for (int j=1; j<partyInfo[i].size(); j++) {
				union(firstPeople, partyInfo[i].get(j));
			}
		}
		
		
		int result = 0;
		
		for (int i=1; i<partyInfo.length; i++) {
			boolean isPossible = true;
			int firstPeople = partyInfo[i].get(0);
			
			for (int j=1; j<trueP.length; j++) {
				if (find(firstPeople) == find(trueP[j])) { // 같으면 false
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				result++;
			}
		}
		
		System.out.println(result);
	
	}
	
	private static int find(int idx) {
		if(idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a;
		}
	}
}
