package Day260825.그래프복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적으로해킹하기_인접리스트와BFS {
	static int n, m;
	static ArrayList<Integer>[] a;
	static int[] answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[n + 1];
		answer = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			a[start].add(end);
		}
		
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			BFS(i);
		}
		int maxValue = 0;
		for (int i = 1; i <= n; i++) {
			maxValue = Math.max(maxValue, answer[i]);
		}
		for (int i = 1; i <= n; i++) {
			if (answer[i] == maxValue) {
				bw.write(i + " ");
			}
		}
		bw.flush();
		bw.close();
		
		
	}
	
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int i : a[nowNode]) {
				if (!visited[i]) {
					visited[i] = true;
					answer[i]++;
					queue.add(i);
				}
				
			}
		}
		
	}

}
