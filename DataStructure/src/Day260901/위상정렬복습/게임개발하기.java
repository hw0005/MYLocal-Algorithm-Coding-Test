package Day260901.위상정렬복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] indegree = new int[n + 1];
		ArrayList<Integer>[] a = new ArrayList[n + 1];
		int[] buildTime = new int[n + 1];
		
		for (int i = 1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			buildTime[i] = Integer.parseInt(st.nextToken());
			
			while (true) {
				int preNode = Integer.parseInt(st.nextToken());
				
				if (preNode == -1) {
					break;
				}
				
				a[preNode].add(i);
				indegree[i]++;
			}
		}
		
		
		int[] waitingTime = new int[n + 1];
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i<=n ;i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for (int next : a[nowNode]) {
				indegree[next]--;
				waitingTime[next] = Math.max(waitingTime[next], waitingTime[nowNode] + buildTime[nowNode]);
				
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
			
		}
		
		for (int i = 1; i<=n; i ++) {
			System.out.println(waitingTime[i] + buildTime[i]);
		}
		
	
	
	}
}
