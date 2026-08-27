package Day260827.다익스트라.최소비용구하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	public static boolean[] visited;
	public static ArrayList<Edge>[] list;
	public static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 버스 수
		
		// 초기화 및 값넣기
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		distance = new int[n + 1];
		
		for (int i = 1; i <=n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <=n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list[start].add(new Edge(end, value));
		}
		
		// 출발 도착 도시 넣고 출력
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		bw.write(dijkstra(start,end) + "\n");

		bw.flush();
		bw.close();
	}
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		distance[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowNode = now.node;
			int nowValue =now.value;
			
			if(!visited[nowNode]) {
				visited[nowNode] = true;
				
				for (Edge next : list[nowNode]) {
					int nextNode = next.node;
					int nextValue = next.value;
					
					if (distance[nextNode] > distance[nowNode] + nextValue) {
						distance[nextNode] = distance[nowNode] + nextValue;
						pq.add(new Edge(nextNode, distance[nextNode]));
					}
				}
			}
		}
		
		return distance[end];
	}
}
