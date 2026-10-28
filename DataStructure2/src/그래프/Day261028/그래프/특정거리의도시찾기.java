package 그래프.Day261028.그래프;

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
	static ArrayList<Integer> list;
	static boolean arrive;
	
	static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		k = Integer.parseInt(st.nextToken()); // 거리 정보
		int x = Integer.parseInt(st.nextToken()); // 출발 번호
		
		a = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a[s].add(e);
		}
		
		visited = new boolean[n+1];
		list = new ArrayList<>();
		arrive = false;
		
		BFS(x);
		
		if (arrive) {
			Collections.sort(list);
			for (int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		else {
			System.out.println(-1);
		}
		
	
	}
	
	private static void BFS (int num) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node (num, 0));
		visited[num] = true;
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			
			if (now.dist == k) {
				arrive = true;
				list.add(now.start);
				continue;
			}
			
			for (int i: a[now.start]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(new Node(i, now.dist + 1));
				}
			}
		}
	}
	
	private static class Node {
		int start;
		int dist;
		
		Node(int start, int dist) {
			this.start = start;
			this.dist = dist;
		}
	}

}
