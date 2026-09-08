package Day260908.최소신장트리복습.다리만들기;

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
	
	// 좌표 이동
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	// 섬 잇기
	static int[][] map;
	static boolean[][] visited;
	static int[] parent;
	
	
	// 다리 건설
	static PriorityQueue<Edge> queue;
	static ArrayList<ArrayList<int[]>> sumlist;
	static ArrayList<int[]> mlist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번째 섬 들어간 후 그룹으로 묶기
		sNum = 1;
		sumlist = new ArrayList<>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					BFS(i, j);
					sNum++;
					sumlist.add(mlist);
					
				}
			}
		}
		
		// 다리 건설
		parent = new int[sNum];
		for (int i=0; i<parent.length; i++) {
			parent[i] = i;
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
					
					while(r+tempR>=0 && r+tempR<n && c+tempC>=0 && c+tempC<m) {
						if (map[r+tempR][c+tempC] == nowS) { // 같은 섬이면 다리 못만듦
							break;
						}
						else if(map[r+tempR][c+tempC] != 0) { // 같은 섬 아니고, 바다도 아니면 -> 다른 섬
							if(blength > 1) {
								queue.offer(new Edge(nowS, map[r+tempR][c+tempC], blength));
							}
							break;
						}
						else { // 바다면
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
		
		int usedEdge = 0;
		int result = 0;
		
		while (!queue.isEmpty()) {
			Edge now = queue.poll();
			
			if (find(now.s) != find(now.e)) {
				union(now.s, now.e);
				usedEdge++;
				result += now.v;
			}
		}
		
		if(usedEdge == sNum-2) {
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
		
		queue.offer(start);
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
				
				while (r+tempR>=0 && r+tempR<n && c+tempC>=0 && c+tempC<m) {
					
					if (!visited[r+tempR][c+tempC] && map[r+tempR][c+tempC] != 0) { // 방문한 적 없고 섬이라면
						addNode(r+tempR, c+tempC, queue);
					}
					else {
						break;
					}
					if (tempR>0) tempR++;
					else if(tempR<0) tempR--;
					else if(tempC>0) tempC++;
					else if(tempC<0) tempC--;
				}
			}
		}
		
		
	}
	
	private static void addNode(int i, int j, Queue<int[]> queue) {
		
		visited[i][j] = true;
		map[i][j] = sNum;
		
		int[] temp = {i, j};
		queue.offer(temp);
		mlist.add(temp);
	}
	
	private static void union (int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
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
