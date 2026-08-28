package Day260828.위상정렬복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 에지 수
		
		ArrayList<Integer>[] a = new ArrayList[n + 1];
		for (int i = 1; i<= n; i++) {
			a[i] = new ArrayList<>();
		}
		
		
		int[] indegree = new int[n + 1];
		for (int i= 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
			indegree[e]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i =1; i<=n; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			System.out.print(nowNode + " ");
			
			for (int next : a[nowNode]) {
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		
		
	}

}
