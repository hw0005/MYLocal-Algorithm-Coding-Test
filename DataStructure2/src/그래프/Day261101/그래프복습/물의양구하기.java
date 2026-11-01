package 그래프.Day261101.그래프복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물의양구하기 {
	static int[] sender = {0, 0, 1, 1, 2, 2};
	static int[] receiver = {1, 2, 0, 2, 0, 1};
	
	static boolean[][] visited;
	static boolean[] answer;
	static int[] now;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		now = new int[3];
		now[0] = a;
		now[1] = b;
		now[2] = c;
		
		answer = new boolean[201];
		visited = new boolean[201][201];
		
		BFS();
		
		for (int i=0; i<answer.length; i++) {
			if(answer[i]) {
				System.out.print(i + " ");
			}
		}
	}
	
	private static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0,0));
		visited[0][0] = true;
		answer[now[2]] = true;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int a = node.a;
			int b = node.b;
			int c = now[2] - a - b;
			
			for (int i=0; i<6; i++) {
				int[] next = {a, b, c};
				
				next[receiver[i]] += next[sender[i]];
				next[sender[i]] = 0;
				
				if (next[receiver[i]] > now[receiver[i]]) {
					next[sender[i]] = next[receiver[i]] - now[receiver[i]];
					next[receiver[i]] = now[receiver[i]];
				}
				
				if(!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					queue.add(new Node(next[0], next[1]));
					
					if (next[0] == 0) {
						answer[next[2]] = true;
					}
				}
			}
		}
	}
	
	private static class Node {
		int a;
		int b;
		Node(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
}
