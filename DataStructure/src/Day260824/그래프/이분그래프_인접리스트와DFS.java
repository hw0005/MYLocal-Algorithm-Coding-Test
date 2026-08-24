package Day260824.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프_인접리스트와DFS {

	static ArrayList<Integer>[] a;
	static int[] check;
	static boolean[] visited;
	static boolean isEven;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 노드
			int e = Integer.parseInt(st.nextToken()); // 간선(에지)
			a = new ArrayList[v + 1];
			check = new int[v + 1];
			visited = new boolean[v + 1];
			isEven = true; // 같아?
			
			for (int i = 1; i <= v; i++) {
				a[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				a[start].add(end);
				a[end].add(start);
			}
			
			for (int i = 1; i <= v; i++) {
				if (isEven) {
					DFS(i);
				}
				else {
					break;
				}
			}
			
			if(isEven) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}
		
	}
	
	// 0과 1로 하면서 하기 1일때 0, 2일때 1, 3일 떄 0 이렇게 되면 이분그래프가 됨
	private static void DFS(int node) {
		visited[node] = true;
		
		for (int i : a[node]) {
			if (!visited[i]) {
				check[i] = (check[node] + 1) % 2;
				DFS(i);
			}
			else if (check[i] == check[node]){
				isEven = false;
			}
		}
	}

}
