package 그래프.Day261030.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말쟁이가되긴싫어 {
	static int[] parent;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> truth;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수
		
		// 진실 아는 사람 정보
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); // 진실 아는 사람 수
		truth = new ArrayList<>();
		for (int i=0; i<t; i++) {
			truth.add(Integer.parseInt(st.nextToken()));
		}
		
		// 파티 정보
		list = new ArrayList[m+1];
		for (int i=0; i<m; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int saramsu = Integer.parseInt(st.nextToken());
			for (int j=0; j<saramsu; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	
		parent = new int[n+1];
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		// 담기 끝 거짓말할 수 있는 최대
		int count = 0;
		for (int i=0; i<m; i++) {
			int firstPeople = list[i].get(0);
			for (int j=1; j<list[i].size(); j++) {
				union(firstPeople, list[i].get(j));
			}
		}
		
		for (int i=0; i<m; i++) {
			boolean isPossible = true;
			
			int currentParty = list[i].get(0);
			for (int j=0; j<truth.size(); j++) {
				if (find(currentParty) == find(truth.get(j))) {
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
