package 동적계획법.Day261104.유니온파인드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어 {
	static int[] parent;
	static int[] trueP; // 진실 아는 사람
	static ArrayList<Integer>[] a; // 파티 정보
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		
		parent = new int[n+1];
		a = new ArrayList[m+1];
		
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		// 진실 아는 거 정보 저장
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		trueP = new int[k+1];
		for (int i=1; i<=k; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}
		
		// 파티 정보 저장
		for (int i=1; i<=m; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int saramsu = Integer.parseInt(st.nextToken());
			for (int j=0; j<saramsu; j++) {
				a[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		//----------------------------------------------------------
		
		for (int i=1; i<a.length; i++) {
			int firstPeople = a[i].get(0);
			for (int j=1; j<a[i].size(); j++) {
				union(firstPeople, a[i].get(j));
			}
		}
		
		int count = 0;
		for (int i=1; i<a.length; i++) {
			boolean isPossible = true;
			int firstPeople = a[i].get(0);
			
			for (int j=1; j<trueP.length; j++) {
				if(find(firstPeople) == find(trueP[j])) {
					isPossible = false;
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
		if(idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
		
	}

}
