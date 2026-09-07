package Day260907.트리알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	static ArrayList<Integer>[] list;
	static int[] answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 노드 수
		
		// 초기화
		list = new ArrayList[n + 1];
		answer = new int[n + 1];
		visited = new boolean[n + 1];
		
		for (int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		DFS(1);
		for (int i=2; i<=n; i++) {
			System.out.println(answer[i]);
		}
		
		
		
	}
	
	private static void DFS(int number) {
		visited[number] = true;
		for (int next : list[number]) {
			if (!visited[next]) {
				answer[next] = number;
				DFS(next);
			}
			
			
			
		}
		
	}

}
