package Day260831.벨만포드.타임머신으로빨리가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타임머신으로빨리가기 {
	static int[] distance;
	static Edge[] edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수 
		int m = Integer.parseInt(st.nextToken()); // 경로 수

		edges = new Edge[m + 1];
		distance = new int[n + 1];
		for (int i = 1; i<=n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, value);
		}
		
		
		//벨만-포드 시작
		distance[1] = 0;
		for (int i = 1; i<n; i++) {
			for (int j = 0; j< m; j++) {
				Edge edge = edges[j];
				
				if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.value) {
					distance[edge.end]= distance[edge.start] + edge.value;
				}
			}
		}
		boolean mCycle = false;
		for (int i = 0; i<m; i++) {
			Edge edge = edges[i];
			if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.value) {
				mCycle = true;
			}
		}
		
		if (!mCycle) {
			for (int i = 2; i<=n; i++) {
				if(distance[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				}
				else {
					System.out.println(distance[i]);
				}
			}
		}
		else {
			System.out.println(-1);
		}
		
		
	}

}
