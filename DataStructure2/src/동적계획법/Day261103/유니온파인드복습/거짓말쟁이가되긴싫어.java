package 동적계획법.Day261103.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어 {
	static int[] parent;
	static ArrayList<Integer>[] pInfo;
	static int[] trueP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		
		parent = new int[n+1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
		trueP = new int[k+1];
		for (int i=1; i<=k; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}
		
		
		pInfo = new ArrayList[m];
		for (int i=0; i<m; i++) {
			pInfo[i] = new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int partySize = Integer.parseInt(st.nextToken());
			for (int j=0; j<partySize; j++) {
				pInfo[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		//---------------------------------------------------------
		
		for (int i=0; i<pInfo.length; i++) {
			int firstPeople = pInfo[i].get(0);
			for (int j=1; j<pInfo[i].size(); j++) {
				union(firstPeople, pInfo[i].get(j));
			}
		}
		
		int count = 0;
		
		for (int i=0; i<pInfo.length; i++) {
			boolean isPossible = true;
			int representitive = pInfo[i].get(0);
			
			for (int j=1; j<trueP.length; j++) {
				if(find(representitive) == find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
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
		if(idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}

}
