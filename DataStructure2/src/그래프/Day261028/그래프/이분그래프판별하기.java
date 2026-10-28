package 그래프.Day261028.그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분그래프판별하기 {
	static boolean[] visited;
	static ArrayList<Integer>[] a;
	static int[] check;
	static boolean arrive;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine()); // 에지 케이스
		
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a = new ArrayList[v+1];
			visited = new boolean[v+1];
			check = new int[v+1];
			arrive = false;
			for (int b=1; b<=v; b++) {
				a[b] = new ArrayList<>();
			}
			
			for (int b=0; b<e; b++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				a[s].add(end);
				a[end].add(s);
			}
			
			for (int c=1; c<=v; c++) {
				if(!arrive) {
					DFS(c);
				}
				else {
					break;
				}
			}
			
			if(!arrive) {
				bw.append("YES\n");
			}
			else {
				bw.append("NO\n");
			}
		}
		bw.flush();
		
	}
	private static void DFS(int num) {
		
		visited[num] = true;
		
		for (int i: a[num]) {
			if(!visited[i]) {
				check[i] = (check[num] + 1)% 2;
				DFS(i);	
			}
			else if (check[i] == check[num]) {
				arrive = true;
			}
			
		}
	}

}
