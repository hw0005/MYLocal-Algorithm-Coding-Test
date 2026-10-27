package 그래프.Day261027.그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분그래프판별하기 {
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static boolean cycle;
	static int[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		
		for (int l=0; l<k; l++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken()); // 노드 수
			int e = Integer.parseInt(st.nextToken()); // 에지 수
			
			a = new ArrayList[v+1];
			
			for (int i=1; i<=v; i++) {
				a[i] = new ArrayList<>();
			}
			
			for (int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				a[start].add(end);
				a[end].add(start);
			}
			cycle = false;
			check = new int[v+1];
			visited = new boolean[v+1];
			
			for (int i=1; i<=v; i++) {
				if (cycle) {
					break;
				}
				if (!visited[i]) {
					DFS(i);
				}
			}
			
			if(cycle) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
			
		}
	}
	
	private static void DFS(int num) {
		visited[num] = true;
		
		for (int i: a[num]) {
			if(cycle) {
				return;
			}
			if(!visited[i]) {
				check[i] = (check[num] + 1) % 2;
				DFS(i);
			}
			else if(check[num] == check[i]) {
				cycle = true;
				return;
			}
		}
		
	}

}
