package Day260901.위상정렬복습;

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
		
		int v = Integer.parseInt(st.nextToken()); // 노드 수
		int e = Integer.parseInt(st.nextToken()); // 에지 수
		
		ArrayList<Integer>[] a = new ArrayList[v + 1];
		int[] indegree = new int[v + 1];
		
		for (int i = 1; i<=v; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i = 0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			a[start].add(end);
			indegree[end]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i<=v; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			System.out.println(nowNode + " ");
			
			for (int next : a[nowNode]) {
				indegree[next]--;
				if (indegree[next]==0) {
					queue.offer(next);
				}
			}
		}

		
	}

}
