package Day260829.다익스트라복습.k번째최단경로구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class k번째최단경로구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		int k = Integer.parseInt(st.nextToken()); // k번째 최단경로
		
		// 초기화
		
		// 1.
		PriorityQueue<Integer>[] dq = new PriorityQueue[n + 1];
		Comparator<Integer> cp = new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1; // 내림차순 -> 큰 거 갱신하려고
			}
		};
		
		for (int i =1 ;i<=n; i++) {
			dq[i] = new PriorityQueue<>(k, cp);
		}
		
		// 2.
		int[][] w = new int[1001][1001];
		for (int i = 0 ;i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			w[s][e] = v;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		dq[1].add(0);
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowNode = now.node; // 1번 노드 들어갔는데
			int nowValue = now.value;
			
			for (int adjNode = 1; adjNode <= n; adjNode++) {
				if (w[nowNode][adjNode] != 0) {
					if(dq[adjNode].size() < k) {
						dq[adjNode].add(w[nowNode][adjNode] + nowValue);
						pq.add(new Edge(adjNode, w[nowNode][adjNode] + nowValue));
					}
					
					else if (dq[adjNode].peek() > nowValue + w[nowNode][adjNode]) {
						dq[adjNode].poll();
						dq[adjNode].add(nowValue + w[nowNode][adjNode]);
						pq.add(new Edge(adjNode, nowValue + w[nowNode][adjNode]));
					}
				}
			}

		}
		
		for (int i = 1; i<=n; i++) {
			if (dq[i].size() == k) {
				System.out.println(dq[i].peek());
			}
			else {
				System.out.println("-1");
			}
		}
		
	}

}
