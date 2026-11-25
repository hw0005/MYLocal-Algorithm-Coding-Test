package 그래프.Day261125.위상정렬복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발하기 {
	static ArrayList<Integer>[] a;
	static int[] indegree;
	static int[] selfBuildTime;
	static int[] answer;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		indegree = new int[n+1];
		a = new ArrayList[n+1];
		selfBuildTime = new int[n+1];
		answer = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			selfBuildTime[i] = Integer.parseInt(st.nextToken());
			
			while (true) {
				int r = Integer.parseInt(st.nextToken());
				
				if(r==-1) {
					break;
				}
				
				a[r].add(i);
				indegree[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i=1; i<=n; i++) {
			answer[i] = selfBuildTime[i];
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int next : a[now]) {
				answer[next] = Math.max(answer[next], answer[now] + selfBuildTime[next]);
				
				indegree[next]--;
				if(indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<=n; i++) {
			sb.append(answer[i] + "\n");
		}
		System.out.println(sb);
	}

}
