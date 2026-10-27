package 그래프.Day261027.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적으로해킹하기 {
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
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
		answer = new int[n+1];
		
		for (int i=1;i<=n; i++) {
			visited = new boolean[n+1];
			BFS(i);
		}
		
		int maxVal = 0;
		for (int i=1; i<=n; i++) {
			if (answer[i] > maxVal) {
				maxVal = answer[i];
			}
		}
		
		for (int i=1; i<=n; i++) {
			if (maxVal == answer[i]) {
				System.out.print(i + " ");
			}
		}
		
	}
	
	private static void BFS(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visited[num] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i: a[now]) {
				if(!visited[i]) {
					visited[i] = true;
					answer[i]++;
					queue.add(i);
				}
			}
		}
	}
}