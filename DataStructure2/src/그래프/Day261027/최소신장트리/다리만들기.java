package 그래프.Day261027.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {
	static int n, m, sNum;
	static int[] parent;
	static boolean[][] visited;
	static int[][] map;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	static ArrayList<int[]> sameList;
	static ArrayList<ArrayList<int[]>> sumList;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n][m];
		map = new int[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sNum = 1;
		sumList = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					BFS(i, j);
					sNum++;
					sumList.add(sameList);
				}
			}
		}
		
		pq = new PriorityQueue<>();
		
		for (int i=0; i<sumList.size(); i++) {
			ArrayList<int[]> now = sumList.get(i);
			for (int j=0; j<now.size(); j++) {
				int x = now.get(j)[0];
				int y = now.get(j)[1];
				int nowS = map[x][y];
				
				for (int k=0; k<4; k++) {
					int nx = dx[k] + x;
					int ny = dy[k] + y;
					int blength = 0;
					
					while (nx>=0 && ny>=0 && nx<n && ny<m) {
						if (nowS == map[nx][ny]) {
							break;
						}
						else if(map[nx][ny] != 0) {
							if (blength > 1) {
								pq.add(new Edge(nowS, map[nx][ny], blength));
							}
							break;
						}
						else {
							blength++;
						}
						nx += dx[k];
						ny += dy[k];
					}
				}
			}
		}
		
		parent = new int[sNum];
		int usedEdge = 0;
		int result = 0;
		
		for (int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (find(now.start) != find(now.end)) {
				union(now.start, now.end);
				usedEdge++;
				result += now.value;
			}
		}
		
		if(usedEdge == sNum - 2) {
			System.out.println(result);
		}
		else {
			System.out.println(-1);
		}
		
		
	}
	
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		sameList = new ArrayList<>();
		visited[i][j] = true;
		map[i][j] = sNum;
		
		
		queue.add(new int[] {i, j});
		sameList.add(new int[] {i, j});
		
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int k=0; k<4; k++) {
				int nx = dx[k] + now[0];
				int ny = dy[k] + now[1];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if (!visited[nx][ny] && map[nx][ny] != 0) {
						addNode(nx, ny, queue);
					}
				}
			}
		}
		
	}
	
	private static void addNode(int i, int j, Queue<int[]> queue) {
		visited[i][j] = true;
		map[i][j] = sNum;
		queue.add(new int[] {i, j});
		sameList.add(new int[] {i, j});
	}
	
	
	private static void union (int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a!=b) {
			parent[b] = a;
		}
	}
	
	private static int find(int idx) {
		if (idx == parent[idx]) {
			return idx;
		}
		else {
			return parent[idx] = find(parent[idx]);
		}
	}
	
	private static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int value;
		
		Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.value - e.value;
		}
	}

}
