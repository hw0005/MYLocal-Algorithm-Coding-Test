package 그래프.Day261123.위상정렬복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 임계경로구하기 {
	static ArrayList<Node>[] a;
	static ArrayList<Node>[] reverseA;
	static int[] indegree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 도로 수
		
		a = new ArrayList[n+1];
		reverseA = new ArrayList[n+1];
		indegree = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
			reverseA[i] = new ArrayList<>();
		}
		
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			a[start].add(new Node(end, value));
			reverseA[end].add(new Node(start, value));
			indegree[end]++;
		}
		
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		Queue<Integer> queue = new LinkedList<>();
		int[] answer = new int[n+1];
		answer[start] = 0;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (Node next : a[now]) {
				indegree[next.idx]--;
				
				answer[next.idx] = Math.max(answer[next.idx], answer[now] + next.value);
				
				if(indegree[next.idx] == 0) {
					queue.add(next.idx);
				}
			}
		}

		
		visited = new boolean[n+1];
		queue = new LinkedList<>();
		int resultCount = 0;
		
		visited[end] = true;
		queue.add(end);
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (Node next : reverseA[now]) {
				
				if(answer[now] == answer[next.idx] + next.value) {
					resultCount++;
					
					if(!visited[next.idx]) {
						visited[next.idx] = true;
						queue.add(next.idx);
					}
				}
			}
		}
		
		System.out.println(answer[end]);
		System.out.println(resultCount);
	}
	
	private static class Node {
		int idx;
		int value;
		
		Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}

}
