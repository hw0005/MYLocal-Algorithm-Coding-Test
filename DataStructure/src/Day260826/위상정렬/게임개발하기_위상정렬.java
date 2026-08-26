package Day260826.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발하기_위상정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 건물 종류 수
		
		// 1. 선언
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		int[] selfBuildTime = new int[n + 1]; // 나혼자 짓는 데 필요한 시간
		int[] indegree = new int[n + 1];
		
		// 2. 인접리스트 초기화
		for (int i = 0; i <= n; i++) {
			a.add(new ArrayList<>());
		}
		
		// 3.  값넣기
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 짓는 시간 담기
			selfBuildTime[i] = Integer.parseInt(st.nextToken());
			
			while (true) {
				int preNode = Integer.parseInt(st.nextToken()); // 짓기 위해 전의 노드
				
				if (preNode == - 1) {
					break;
				}
				// 인접리스트 담기
				a.get(preNode).add(i);
				// 진입차수 담기
				indegree[i]++;
			}
		}
		
		// 위상정렬
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		int[] waitingTime = new int[n + 1]; // 내가 짓기 전까지 기다리는 시간
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for (int next : a.get(nowNode)) {
				indegree[next]--;
				
				waitingTime[next] = Math.max(waitingTime[next], waitingTime[nowNode] + selfBuildTime[nowNode]);
				
				if (indegree[next] == 0) {
					queue.offer(next);
				}
				
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.println(waitingTime[i] + selfBuildTime[i]);
		}
		
	}

}
