package Day260912.최소신장트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {
	// 기본
	static int n, m, sNum;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] parent;
	
	//섬 잇기
	static int[][] map;
	static boolean[][] visited;
	
	// 다리 건설
	static ArrayList<ArrayList<int[]>> sumlist;
	static ArrayList<int[]> mlist;
	static PriorityQueue<Edge> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sumlist = new ArrayList<>();
		sNum = 1;
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					DFS(i, j);
					sNum++;
					sumlist.add(mlist);
				}
			}
		}
		
		
		queue = new PriorityQueue<>();
		
		for (int i=0; i<sumlist.size(); i++) {
			ArrayList<int[]> now = sumlist.get(i);
			for (int j=0; j<now.size(); j++) {
				int r = now.get(j)[0];
				int c = now.get(j)[1];
				int nowS = map[r][c];
				
				for (int d=0; d<4; d++) {
					int mr = r + dr[d];
					int mc = c + dc[d];
					int blength = 0;
					
					while (mr>=0 && mr<n && mc>=0 && mc<m) {
						if(nowS == map[mr][mc]) { // 현재위치와가 섬위치라면
							break;
						}
						else if(map[mr][mc] != 0) {
							if (blength > 1) {
								queue.add(new Edge(nowS, map[mr][mc], blength));
							}
							break;
						}
						else {
							blength++;
						}
						mr += dr[d];
						mc += dc[d];
					}
				}
			}
		}
		
		parent = new int[sNum];
		for (int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		int usedEdge = 0;
		int result = 0;
		
		while (!queue.isEmpty()) {
			Edge now = queue.poll();
			
			if (find(now.start)!= find(now.end)) {
				union(now.start, now.end);
				usedEdge++;
				result += now.value;
			}
		}
		
		if (usedEdge == sNum - 2) {
			System.out.println(result);
		}
		else {
			System.out.println(-1);
		}
		
	}
	
	private static void DFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		mlist = new ArrayList<>();
		int[] start = {i, j};
		
		queue.add(start);
		mlist.add(start);
		
		visited[i][j] = true;
		map[i][j] = sNum;
		
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			
			for (int d=0; d<4; d++) {
				int mr = r + dr[d];
				int mc = c + dc[d];
				
				if (mr>=0 && mr<n && mc>=0 && mc<m) {
					if (!visited[mr][mc] && map[mr][mc] != 0) {
						addNode(mr, mc, queue);
					}
					
					mr += dr[d];
					mc += dc[d];
				}
			}
		}
	}
	
	private static void addNode(int i, int j, Queue<int[]> queue) {
		int[] now = {i, j};
		queue.add(now);
		mlist.add(now);
		visited[i][j] = true;
		map[i][j] = sNum;
	}
	
	
	
	private static void union(int a, int b) {
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
	
	
	
	public static class Edge implements Comparable<Edge> {
		int start, end, value;
		
		Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		
		public int compareTo(Edge e) {
			return this.value - e.value;
		}
	}

}
