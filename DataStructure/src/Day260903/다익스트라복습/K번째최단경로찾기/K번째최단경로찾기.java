package Day260903.다익스트라복습.K번째최단경로찾기;

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
		int k = Integer.parseInt(st.nextToken()); // k 번째 수
		
		ArrayList<Edge>[] list = new ArrayList[n + 1];
		
		PriorityQueue<Integer>[] dq = new PriorityQueue[n + 1];
		Comparator<Integer> cp = new Comparator<>() {
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1; // 내림차순
			}
		};
		
		for (int i = 1; i<=n; i++) {
			dq[i] = new PriorityQueue<>(k, cp);
		}
		
		for (int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[s].add(new Edge(e, v));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		dq[1].add(0);
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowNode = now.node;
			
			for (Edge next : list[now.node]) {
				if(dq[next.node].size() < k) {
					dq[next.node].add(now.value + next.value);
					pq.offer(new Edge(next.node, now.value + next.value));
				}
				else if (dq[next.node].peek() > now.value + next.value) {
					dq[next.node].poll();
					dq[next.node].add(now.value + next.value);
					pq.offer(new Edge(next.node, now.value + next.value));
				}
				
			}
		}
		for (int i = 1; i<=n; i++) {
			if (dq[i].size() == k) {
				System.out.println(dq[i].peek());
			}
			else {
				System.out.println(-1);
			}
		}
		
		
		
	}

}
