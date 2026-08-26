package Day260826.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_위상정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 키 비교횟수
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		int[] indegree = new int[n + 1];
		
		for (int i = 0; i <= n; i++) {
			a.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a.get(s).add(e);
			
			indegree[e]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			System.out.print(nowNode + " ");
			
			for (int i : a.get(nowNode)) {
				indegree[i]--;
				if (indegree[i] == 0) {
					queue.offer(i);
				}
			}
		}
		
		
		
		
		
	}

}
