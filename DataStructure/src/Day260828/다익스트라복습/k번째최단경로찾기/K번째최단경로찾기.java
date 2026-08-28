package Day260828.다익스트라복습.k번째최단경로찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째최단경로찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수 
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		int k = Integer.parseInt(st.nextToken()); // k번째 최단경로
		
		int[][] w = new int[1001][1001];
		PriorityQueue<Integer>[] dq = new PriorityQueue[n + 1];
		Comparator<Integer> cp = new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1; // 내림차순
			}
		};
		
		for (int i = 1; i<=n; i++) {
			dq[i] = new PriorityQueue<>(k, cp); // 각도시마다 k번째까지 최단경로 저장, 내림차순
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			w[a][b] = c;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		dq[1].add(0);
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			for (int adjNode = 1; adjNode <= n; adjNode++) {
				if (w[now.node][adjNode] != 0) { // 값 있으면
					
					if (dq[adjNode].size() < k) {
						dq[adjNode].add(now.value +  w[now.node][adjNode]);
						pq.add(new Edge(adjNode, now.value + w[now.node][adjNode]));
					}
					else if (dq[adjNode].peek() > now.value + w[now.node][adjNode]) {
						dq[adjNode].poll();
						dq[adjNode].add(now.value + w[now.node][adjNode]);
						pq.add(new Edge(adjNode, now.value + w[now.node][adjNode]));
					}
				}
			}
		}
		for (int i = 1; i<=n; i++) {
			if(dq[i].size() == k) {
				bw.write(dq[i].poll() + "\n");
			}
			else {
				bw.write("INF");	
			}
		}
		bw.flush();
		bw.close();
		
	}

}
