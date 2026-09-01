package Day260901.다익스트라복습.K번째최단경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째최단경로찾기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		int k = Integer.parseInt(st.nextToken()); // k번째 최단 경로
		
		PriorityQueue<Integer>[] distanceQ = new PriorityQueue[n + 1]; // dq배열
		Comparator<Integer> cp = new Comparator<>() {
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1; // 내림차순
			}
		};
		for (int i = 1; i<=n; i++) {
			distanceQ[i] = new PriorityQueue<>(k, cp);
		}
		
		// 담을 인접리스트 선언
		ArrayList<Edge>[]  list = new ArrayList[n + 1];
		for (int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 시작
			int v = Integer.parseInt(st.nextToken()); // 마지막
			int w = Integer.parseInt(st.nextToken()); // 가중치
			list[u].add(new Edge(v, w));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		distanceQ[1].add(0);
		
		while (!pq.isEmpty()) {
			Edge now  = pq.poll();
			int nowNode = now.node;
			
			for (Edge next : list[nowNode]) {
				// 1번째~ i번째 가는 도시의 k번째 경로 추출이잖아
				int accValue = now.value + next.value;
				
				if (distanceQ[next.node].size() < k) {
					distanceQ[next.node].add(accValue);
					pq.add(new Edge(next.node, accValue));
				}
				else if (distanceQ[next.node].peek() > accValue) {
					distanceQ[next.node].poll();
					distanceQ[next.node].add(accValue);
					pq.add(new Edge(next.node, accValue));
				}
			}
		}
		
		for (int i = 1; i<=n; i++) {
			if (distanceQ[i].size() == k) {
				System.out.println(distanceQ[i].peek());
			}
			else {
				System.out.println(-1);
			}
		}
		
		
	}

}
