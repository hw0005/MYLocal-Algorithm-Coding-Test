package Day260902.다익스트라복습.k번째최단경로구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째최단경로구하기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		int k= Integer.parseInt(st.nextToken()); // k번째 경로 탐색
		
		// 초기화
		PriorityQueue<Integer>[] distanceQ = new PriorityQueue[n + 1];
		Comparator<Integer> cp = new Comparator<>() {
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1; // 내림차순
			}
		};
		
		for (int i = 1; i<=n; i++) {
			distanceQ[i] = new PriorityQueue<>(k, cp);
		}
		
		// list로 담기
		ArrayList<Edge>[] list = new ArrayList[n + 1];
		for (int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[s].add(new Edge(e, v));
			
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		distanceQ[1].add(0);
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowNode = now.node;
			
			for (Edge next : list[nowNode]) {
				if (distanceQ[next.node].size() < k) {
					distanceQ[next.node].add(now.value + next.value);
					pq.offer(new Edge(next.node, now.value + next.value));
				}
				else if (distanceQ[next.node].peek() > now.value + next.value) {
					distanceQ[next.node].poll();
					pq.offer(new Edge(next.node, next.value + now.value));
				}
			}
		}
		for (int i = 1; i<=n; i++) {
			if (distanceQ[i].size() == k) {
				System.out.println(distanceQ[i].poll());
			}
			else {
				System.out.println(-1);
			}
			
			
		}
		
	}
}
