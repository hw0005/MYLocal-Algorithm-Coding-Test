package Day260902.벨만포드복습.타임머신으로빨리가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타임머신으로빨리가기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[m + 1];
		long[] dist = new long[n + 1];
		
		for (int i =1; i<=n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(s, e, v);
		}
		
		dist[1] = 0;
		
		for (int i = 1; i <n; i++) {
			for (int j = 1; j<=m; j++) {
				Edge edge = edges[j];
				
				if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.value) {
					dist[edge.end] = dist[edge.start] + edge.value;
				}
				
			}
		}
		
		boolean mCycle = false;
		
		for (int i = 1; i<=m; i++) {
			Edge edge = edges[i];
			if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.value) {
				mCycle = true;
			}
		}
		
		if (!mCycle) {
			for (int i = 2; i<=n;i++) {
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
