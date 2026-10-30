package 그래프.Day261030.그래프복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적으로해킹하기 {

	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static int[] answer;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n+1];
		answer = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			a[start].add(end);
		}
		
		visited= new boolean[n+1];
		for (int i=1; i<=n; i++) {
			Arrays.fill(visited, false);
			BFS(i);
		}
		
		int maxValue = 0;
		for (int i=0; i<answer.length; i++) {
			maxValue = Math.max(maxValue, answer[i]);
		}
		
		
		for (int i=0; i<answer.length; i++) {
			if(maxValue == answer[i]) {
				System.out.println(i);
			}
		}
		
		
	}
	
	private static void BFS(int num) {
		Queue<Integer> queue = new LinkedList<>();
		visited[num] = true;
		queue.add(num);
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i: a[now]) {
				if(!visited[i]) {
					visited[i] = true;
					answer[i]++;
					queue.add(i);
				}
			}
		}
	}

}
