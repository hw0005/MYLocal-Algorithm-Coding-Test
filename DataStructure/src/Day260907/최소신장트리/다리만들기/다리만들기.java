package Day260907.최소신장트리.다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {
	// 변수
	static int n, m, sNum;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] parent;
	// 섬 추가
	static int[][] map;
	static boolean[][] visited;
	
	static ArrayList<ArrayList<int[]>> sumlist;
	static ArrayList<int[]> mlist;
	// 다리 건설
	static PriorityQueue<Edge> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sNum = 1;
		sumlist = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					BFS(i, j);
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
					int tempR = dr[d];
					int tempC = dc[d];
					int blength = 0;
					while (r+tempR >=0 && r+tempR<n && c+tempC>=0 && c+tempC<m) {
						if (map[r+tempR][c+tempC] == nowS) { // 지금 돌고있는 게 같은 섬이라면
							break;
						}
						else if(map[r+tempR][c+tempC] != 0) { // 같은 섬 아니고 바다도 아니면
							if (blength > 1) { // 다리길이가 1이상일 때, 연결
								queue.offer(new Edge(nowS, map[r+tempR][c+tempC], blength));
							}
							break;
						}
						else { // 바다면 추가
							blength++;
						}
						if (tempR > 0) tempR++;
						else if (tempR < 0) tempR--;
						else if (tempC > 0) tempC++;
						else if (tempC < 0) tempC--;
					}
				}
			}
		}
		
		parent = new int[sNum];
		for (int i =0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		int usedEdge = 0;
		int result = 0;
		
		while (!queue.isEmpty()) {
			Edge now = queue.poll();
			if (find(now.start) != find(now.end)) {
				union(now.start, now.end);
				usedEdge++;
				result += now.value;
			}
		}
		
		if (usedEdge == sNum-2) {
			System.out.println(result);
		}
		else {
			System.out.println(-1);
		}
		
		
	}
	
	private static void BFS(int i, int j) {
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
				int tempR = dr[d];
				int tempC = dc[d];
				
				while (r+tempR >=0 && r+tempR<n && c+tempC>=0 && c+tempC<m) {
					if (!visited[r+tempR][c+tempC] && map[r+tempR][c+tempC] != 0) {
						addNode(r+tempR, c+tempC, queue);
					}
					else {
						break;
					}
					
					if (tempR > 0) tempR++;
					else if (tempR < 0) tempR--;
					else if (tempC > 0) tempC++;
					else if (tempC < 0) tempC--;
				}
			}
		}
	}
	
	private static void addNode(int i, int j, Queue<int[]> queue) {
		int[] now ={i, j};
		queue.add(now);
		mlist.add(now);
		
		visited[i][j] = true;
		map[i][j] = sNum;
		
		
		
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
}
