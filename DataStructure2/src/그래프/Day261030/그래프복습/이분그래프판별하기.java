package 그래프.Day261030.그래프복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분그래프판별하기 {
	static ArrayList<Integer>[] a; 
	static boolean[] visited;
	static int[] answer;
	static boolean isEven = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		
		for (int b=0; b<k; b++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken()); // 노드 수
			int e = Integer.parseInt(st.nextToken()); // 에지 수
			
			a = new ArrayList[v+1];
			visited = new boolean[v+1];
			answer = new int[v+1];
			
			
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
			
			for (int i=1; i<=v; i++) {
				if(isEven) {
					break;
				}
				else {
					DFS(i);
				}
			}
			
			
			if(isEven) {
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
			if(!visited[i]) {
				answer[i] = (answer[num] + 1) % 2;
				DFS(i);
			}
			else if(answer[i] == answer[num]) {
				isEven = true;
				return;
			}
		}
	}

}
