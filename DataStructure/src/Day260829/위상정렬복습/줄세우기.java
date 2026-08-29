package Day260829.위상정렬복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	static int[] indegree;
	static ArrayList<Integer>[] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 에지 수
		
		// 초기화
		indegree = new int[n + 1];
		a = new ArrayList[n + 1];
		
		for (int i= 1; i<= n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i= 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			a[start].add(end);
			indegree[end]++;
			
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i= 1; i<= n; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
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
