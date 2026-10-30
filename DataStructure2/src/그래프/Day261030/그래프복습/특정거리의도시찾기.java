package 그래프.Day261030.그래프복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기 {
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static ArrayList<Integer> answer;
	static int k, x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		k = Integer.parseInt(st.nextToken()); // 거리 정보
		x = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		
		
		visited = new boolean[n+1];
		a = new ArrayList[n+1];
		answer = new ArrayList<>();
		
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
		}
		
		BFS(x);
		
		
		if(answer.size() != 0) {
			for (int i=0; i<answer.size(); i++) {
				Collections.sort(answer);
				System.out.print(answer.get(i) + " ");
			}
		}
		else {
			System.out.println(-1);
		}
}
	
	private static void BFS(int num) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(num, 0));
		visited[num] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(now.value == k) {
				answer.add(now.end);
				continue;
			}
			
			for (int i: a[now.end]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(new Node(i, now.value + 1));
				}
			}
		}
	}
	
	private static class Node {
		int end;
		int value;
		Node(int end, int value) {
			this.end = end;
			this.value = value;
		}
	}

}
