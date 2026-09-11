package Day260911.최소신장트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {
	static int[] parent; 
	static int n, m, sNum;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	// 섬끼리 잇기
	static int[][] map;
	static boolean[][] visited;
	
	// 다리 건설
	static ArrayList<ArrayList<int[]>> sumlist;
	static ArrayList<int[]> nlist;
	static PriorityQueue<Edge> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sNum = 1;
		sumlist = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					BFS(i, j);
					sNum++;
					sumlist.add(nlist);
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
					int tempR = dr[d];
					int tempC = dc[d];
					int blength = 0;
					
					while (r+tempR>=0 && r+tempR<n && c+tempC>=0 && c+tempC<m) {
						if (map[r+tempR][c+tempC] == nowS) {
							break;
						}
						else if (map[r+tempR][c+tempC] != 0) {
							if (blength > 1) {
								queue.add(new Edge(nowS, map[r+tempR][c+tempC], blength));
							}
							break;
						}
						else {
							blength++;
						}
						
						if (tempR>0) tempR++;
						else if(tempR<0) tempR--;
						else if(tempC>0) tempC++;
						else if(tempC<0) tempC--;
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
			
			if(find(now.start) != find(now.end)) {
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
	
	// 첫번째 들어왔을 때
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		nlist = new ArrayList<>();
		int[] start = {i, j};
		queue.add(start);
		nlist.add(start);
		
		visited[i][j] = true;
		map[i][j] = sNum;
		
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			
			for (int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (nr>=0 && nr<n && nc>=0 && nc<m) {
					if (map[nr][nc] != 0 && !visited[nr][nc]) {
						addNode(nr, nc, queue);
					}
//					else {
//						break;
//					}
					nr += dr[d];
					nc += dc[d];
					
				}
			}
		}
	}
	
	private static void addNode(int i, int j, Queue<int[]> queue) {
		int[] now = {i, j};
		queue.add(now);
		nlist.add(now);
		
		visited[i][j] = true;
		map[i][j] = sNum;
		
	}
	
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a!=b) {
			parent[b] = a;
		}
	}
	public static int find(int idx) {
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
