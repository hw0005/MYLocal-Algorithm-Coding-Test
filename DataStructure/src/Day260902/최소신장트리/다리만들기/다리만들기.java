package Day260902.최소신장트리.다리만들기;

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
	static int[] dr = {-1, 0, 1, 0}; //네 방향탐색
	static int[] dc = {0, 1, 0, -1};
	
	static int[] parent; // 대표노드 저장 배열
	static int[][] map; // 맵 정보 저장 배열
	static boolean[][] visited; // BFS할 때 방문 여부 저장
	
	static ArrayList<ArrayList<int[]>> sumlist;// 모든 섬 정보 저장하기
	static ArrayList<int[]> mlist; // 1개의 섬 정보 저장하기
	static PriorityQueue<Edge> queue; // 다리 정보 저장용 우선순위 큐
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열 
		map = new int[n][n];
		visited = new boolean[n][n];
		
		
		// 정보 저장
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sNum = 1; // 이게 왜 있는 거임
		sumlist = new ArrayList<>();
		
		 // 섬 분리작업수행
		for(int i = 0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (map[i][j] != 0 && !visited[i][j]) { // 섬이고 방문 안 했으면
					BFS(i, j);
					sNum++;
					sumlist.add(mlist);
				}
			}
		}
		
		queue = new PriorityQueue<>();
		
		for (int i = 0; i<sumlist.size(); i++) { // 섬의 각지점에서 만들수 있는 모든 에지 저장
			ArrayList<int[]> now = sumlist.get(i);
			for (int j = 0; j<now.size(); j++) {
				int r = now.get(j)[0];
				int c = now.get(j)[1];
				
				int nowS = map[r][c];
				
				for (int d = 0; d < 4; d++) {
					int tempR = dr[d];
					int tempC = dc[d];
					int blength = 0;
					
					while (r + tempR >= 0 && r + tempR < n && c + tempC>=0 && c + tempC < m) { 
						if (map[r + tempR][c + tempC] == nowS) { // 같은 섬이면 에지 아님
							break;
						}
						else if (map[r + tempR][c + tempC] != 0) { // 같은 섬도 아니고 바다도 아니면
							if (blength > 1) { // 길이 1초과 시 에지 더하기
								queue.add(new Edge(nowS, map[r + tempR][c + tempC], blength));
							}
							break;
						}
						else { // 바다면 다리 길이 연장
							blength++;
						}
						
						if (tempR < 0) tempR--;
						else if (tempR > 0) tempR++;
						else if (tempC < 0) tempC--;
						else if (tempC > 0) tempC++;
					}
					
				}
			}
			
		}
		
		parent = new int[sNum];
		for (int i = 0; i< parent.length; i++) {
			parent[i] = i;
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
		
		if (usedEdge == sNum -2) {
			System.out.println(result);
		}
		else {
			System.out.println(-1);
		}
		
		
	}
	
	private static void union(int a, int b) {
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
	
	
	
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		mlist = new ArrayList<>();
		int[] start = {i, j};
		queue.add(start);
		mlist.add(start);
		
		visited[i][j] = true;
		map[i][j] = sNum;
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			// 받은 i,j와
			int r = now[0];
			int c = now[1];
			
			for (int d = 0; d<4; d++) {
				// 위에 저장한 dr을 넣어본다
				int tempR = dr[d];
				int tempC = dr[d];
				
				while (r + tempR >= 0 && r + tempR < n && c + tempC>=0 && c + tempC < m) { // 안 부딪히게
					// 방문 안 했고 바다가 아니면 같은 섬
					if(!visited[r + tempR][c + tempC] && map[r + tempR][c + tempC] != 0) {
						addNode(r + tempR, c + tempC, queue);
					}
					else {
						break;
					}
					if (tempR < 0) tempR--;
					else if(tempR > 0) tempR++;
					else if (tempC < 0) tempC--;
					else if (tempC > 0) tempC++;
				}
			}
		}
	}
	
	// 특정 위치 섬의 정보로 넣어주는 함수
	private static void addNode(int i, int j, Queue<int[]> queue) {
		map[i][j] = sNum;
		visited[i][j] = true;
		int[] temp = {i, j};
		mlist.add(temp);
		queue.add(temp);
	}

}
