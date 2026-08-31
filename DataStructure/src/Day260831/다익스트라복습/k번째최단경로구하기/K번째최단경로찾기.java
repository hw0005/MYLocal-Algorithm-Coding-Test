package Day260831.다익스트라복습.k번째최단경로구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째최단경로찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		int k = Integer.parseInt(st.nextToken()); // k번째 최단경로 구하기
		int[][] w = new int[1001][1001];
		
		PriorityQueue<Integer>[] distanceQueue = new PriorityQueue[n + 1];
		Comparator<Integer> cp = new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1; // 내림차순
			}
		};
		for (int i = 1; i<=n ;i++) {
			distanceQueue[i] = new PriorityQueue<>(k, cp);
		}
		
		
		for (int i = 0; i<m ;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			w[start][end] = value;
		}
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		distanceQueue[1].add(0);
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowNode = now.node;
			
			for (int adjNode = 1; adjNode <= n; adjNode++) {
				if (w[nowNode][adjNode] != 0) { // 값이 있으면
					
					if(distanceQueue[adjNode].size() < k) {
						distanceQueue[adjNode].add(w[nowNode][adjNode] + now.value);
						pq.add(new Edge(adjNode, w[nowNode][adjNode] + now.value));
					}
					
					else if (distanceQueue[adjNode].peek() > w[nowNode][adjNode] + now.value) {
						distanceQueue[adjNode].poll();
						distanceQueue[adjNode].add(w[nowNode][adjNode] + now.value);
						pq.add(new Edge(adjNode, w[nowNode][adjNode] + now.value));
					}
				}
			}
		}
		for (int i = 1; i<=n ;i++) {
			if (distanceQueue[i].size() == k) {
				System.out.println(distanceQueue[i].peek());
			}
			else {
				System.out.println(-1);
			}
		}
		
	}

}
