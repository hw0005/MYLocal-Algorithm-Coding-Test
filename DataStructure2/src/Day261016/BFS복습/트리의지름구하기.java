package Day261016.BFS복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의지름구하기 {
	static ArrayList<Node>[] a;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 노드 수
		
		a = new ArrayList[n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			
			while (true) {
				int end = Integer.parseInt(st.nextToken());
				
				if (end == -1) {
					break;
				}
				int value = Integer.parseInt(st.nextToken());
				a[start].add(new Node(end, value));
			}
		}
		
		
		visited = new boolean[n+1];
		dist = new int[n+1];
		BFS(1);
		int max = 1;
		for (int i=2; i<=n; i++) {
			if (dist[max] < dist[i]) {
				max = i;
			}
		}
		
		visited = new boolean[n+1];
		dist = new int[n+1];
		BFS(max);
		Arrays.sort(dist);
		System.out.println(dist[n]);
		
		
	}
	private static void BFS(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visited[num] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (Node n : a[now]) {
				if (!visited[n.end]) {
					visited[n.end] = true; 
					dist[n.end] = dist[now] + n.value; 
					queue.add(n.end);
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
