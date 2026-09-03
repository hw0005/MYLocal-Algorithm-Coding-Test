package Day260903.벨만포드복습.타임머신으로빨리가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타임머신으로빨리가기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken()); // 노드 
		int e = Integer.parseInt(st.nextToken()); // 에지
		
		int[] dist = new int[v + 1];
		Edge[] edges = new Edge[e + 1];
		
		for (int i = 1; i<=v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, value);
		}
		
		dist[1] = 0;
		
		for (int i = 1; i<v; i++) {
			for (int j = 1; j<e; j++) {
				Edge edge = edges[j];
				
				if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.value) {
					dist[edge.end] = dist[edge.start] + edge.value;
				}
			}
		}
		
		boolean mCycle = false;
		
		for (int i=1; i<=v; i++) {
			Edge edge = edges[i];
			if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.value) {
				mCycle = true;
				break;
			}
		}
		
		if (!mCycle) {
			for (int i = 2; i<=v;i ++) {
				if (dist[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				}
				else {
					System.out.println(dist[i]);
				}
			}
		}
		else {
			System.out.println(-1);
		}
	
	
	}
	

}
