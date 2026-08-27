package Day260827.다익스트라.K번째최단경로찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째최단경로찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] w = new int[1001][1001];
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 수
		int k = Integer.parseInt(st.nextToken()); // k번째 찾는 수
		
		PriorityQueue<Integer>[] distanceQueue = new PriorityQueue[n + 1];
		Comparator<Integer> cp = new Comparator<>() {
			@Override
			public int compare(Integer o1 ,Integer o2) {
				return o1 < o2 ? 1 : -1; //내림차순
			}
		};
		
		for (int i =0; i< n + 1; i++) {
			distanceQueue[i] = new PriorityQueue<>(k, cp);
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
		distanceQueue[1].add(0);
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			for (int adjNode = 1; adjNode <= n; adjNode++) {
				if (w[now.node][adjNode] != 0) {
					if (distanceQueue[adjNode].size() < k) {
						distanceQueue[adjNode].add(now.value + w[now.node][adjNode]);
						pq.add(new Edge(adjNode, now.value + w[now.node][adjNode]));
					}
					
					else if (distanceQueue[adjNode].peek() > now.value + w[now.node][adjNode]) {
						distanceQueue[adjNode].poll();
						distanceQueue[adjNode].add(now.value + w[now.node][adjNode]);
						pq.add(new Edge(adjNode, now.value + w[now.node][adjNode]));
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (distanceQueue[i].size() == k) {
				bw.write(distanceQueue[i].peek() + "\n");
			}
			else {
				bw.write(-1 + "\n");
			}
		}
	
		bw.flush();
		bw.close();
	}

}
