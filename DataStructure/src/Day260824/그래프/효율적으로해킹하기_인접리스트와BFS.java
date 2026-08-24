package Day260824.그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적으로해킹하기_인접리스트와BFS {
	static ArrayList<Integer>[] a;
	static int[] answer;
	static boolean[] visited;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new ArrayList[n + 1];
		answer = new int[n + 1];
		
		// 값 선언 및 저장
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
		}
		
		// visited 배열 초기화
		for (int i = 1; i <= n; i++) {
			visited= new boolean[n + 1];
			// BFS
			BFS(i);
		}
		
		// 출력
		int maxValue = 0;
		for (int i = 1; i <= n; i++) {
			maxValue = Math.max(maxValue, answer[i]);
		}
		
		for (int i = 1; i <= n; i++) {
			if (maxValue == answer[i]) {
				bw.write(i + " ");
			}
		}
		bw.flush();
		bw.close();
		
	}
	
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int i : a[nowNode]) {
				if (visited[i] == false) {
					visited[i] = true;
					answer[i]++;
					queue.add(i);
				}
			}
			
		}
		
		
	}

}
