package Day260904.벨만포드복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 타임머신으로빨리가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드
		int m = Integer.parseInt(st.nextToken()); // 에지
		
		int[] dist = new int[n + 1];
		Edge[] edges = new Edge[n + 1];
		

		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(start, end, value);
		}
		
		for (int i = 1; i<=n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		
		dist[1] = 0;
		for (int i =1; i<n; i++) {
			for (int j=0; j<m; j++) {
				Edge edge = edges[j];
				if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.value) {
					dist[edge.end] = dist[edge.start] + edge.value;
				}
			}
		}
		
		boolean mCycle = false;
		for (int i = 0; i<m; i++) {
			Edge edge = edges[i];
			if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.value) {
				mCycle = true;
				break;
			}
		}
		
		if (!mCycle) {
			for (int i = 2; i<=n; i++) {
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
