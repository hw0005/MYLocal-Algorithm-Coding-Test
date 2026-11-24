package 그래프.Day261124.위상정렬복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발하기 {
	
	static int[] indegree;
	static ArrayList<Integer>[] a;
	static int[] answer;
	static int[] selfBuildTime;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 건물 종류 수 n
		
		indegree = new int[n+1];
		a = new ArrayList[n+1];
		answer = new int[n+1];
		selfBuildTime = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			selfBuildTime[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				int request = Integer.parseInt(st.nextToken());
				
				if(request == -1) {
					break;
				}
				
				a[request].add(i);
				indegree[i]++;
			}
		}
		
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i=1; i<=n; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		// 첫번째 들어간 게 빠짐
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int next : a[now]) {
				indegree[next]--;
				
				// 지금 지어진 게, 몇개일지 모르니까 Math.max
				// (지금 들어온 것 VS 앞에 거 + 앞에 건물짓는 시간)
				answer[next] = Math.max(answer[next], answer[now] + selfBuildTime[next]);
				
				if(indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		for (int i=1; i<=n; i++) {
			System.out.println(answer[i]);
		}
	}
}
