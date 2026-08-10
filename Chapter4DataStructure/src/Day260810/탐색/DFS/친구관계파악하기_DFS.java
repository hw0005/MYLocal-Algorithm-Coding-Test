package Day260810.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 친구관계파악하기_DFS {
	// 플래그 1개, 인접리스트 1개, 방문배열 1개
	static boolean arrive;
	static ArrayList<Integer>[] a;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arrive = false;
		visited = new boolean[n];
		a = new ArrayList[n];
		
		// 1. 초기화
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<>();
		}
		
		// 2. 값넣기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			// 양방향
			a[s].add(e);
			a[e].add(s);
		}
		
		// 3. DFS실행
		for (int i = 0; i < a.length; i++) {
			DFS(i, 1); // -> 1은 depth임 5되는 순간(5개연결) 끝
			if (arrive) { // arrive 되면 break
				break;
			}
		}
		
		if (arrive) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
	
	private static void DFS (int now, int depth) {
		if (depth == 5 || arrive) { // 재귀함수니까 백트래킹 할 때 arrive=true만 보면 다른 인접리스트를 굳이 탐색 안 해도 되기 떄문에 arrive를 넣어야 함(시간복잡도)
			arrive = true;
			return;
		}
		
		// 지금 현재 true 로 바꿔
		visited[now] = true;
		
		for (int i : a[now]) {
			if (!visited[i]) { // 안 돌았으면 바로 가서 DFS 돌려, 5되면 끝이잖아
				DFS(i, depth + 1);
			}
		}
		
		// 근데 돌았는데 없잖아? false로 바꿔 왜냐면 다른 인접리스트에서 얘를 돌 수도 있으니
		visited[now] = false;
	}


}
