package 그래프.Day261125.위상정렬복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 임계경로 {
	
	static int[] indegree;
	static ArrayList<Node>[] a; 
	static ArrayList<Node>[] reverseA; 
	static boolean[] visited;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		indegree = new int[n+1];
		a = new ArrayList[n+1];
		reverseA = new ArrayList[n+1];
		answer = new int[n+1];
		
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
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (Node next : a[now]) {
				indegree[next.idx]--;
				
				answer[next.idx] = Math.max(answer[next.idx], answer[now] + next.value);
				
				if(indegree[next.idx] == 0) {
					queue.offer(next.idx);
				}
			}
		}
		
		queue = new LinkedList<>();
		visited = new boolean[n+1];
		
		queue.add(end);
		int resultCount = 0;
		visited[end] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (Node next : reverseA[now]) {
				if(answer[now] == answer[next.idx] + next.value) {
					resultCount++;
					if(!visited[next.idx]) {
						visited[next.idx] = true;
						queue.offer(next.idx);
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
