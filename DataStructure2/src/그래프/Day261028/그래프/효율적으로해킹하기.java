package 그래프.Day261028.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적으로해킹하기 {

	static boolean[] visited;
	static ArrayList<Integer>[] a;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken()); // 컴퓨터 수
		int e = Integer.parseInt(st.nextToken()); // 관계 수
		
		a = new ArrayList[v+1];
		answer = new int[v+1];
		
		for (int i=1; i<=v; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			a[s].add(end);
		}
		
		for (int i=1; i<=v; i++) {
			visited = new boolean[v+1];
			BFS(i);
		}
		
		int maxV = 0;
		for (int i=1; i<=v; i++) {
			if (maxV < answer[i]) {
				maxV = answer[i];
			}
		}
		
		for (int i=1; i<=v; i++) {
			if(maxV==answer[i]) {
				System.out.print(i + " ");
			}
		}
		
	}
	private static void BFS(int num) {
		Queue<Integer> queue = new LinkedList<>();
		visited[num] = true;
		queue.add(num);
		answer[num]++;
		
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i : a[now]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
					answer[i]++;
				}
			}
		}
		
	}

}
