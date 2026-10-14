package Day261014.DFS복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 친구관계파악하기 {
	static ArrayList<Integer>[] a;
	static boolean arrive;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 에지 수
		
		a = new ArrayList[n];
		
		for (int i=0; i<n; i++) {
			a[i] = new ArrayList<>();
		}
		v = new boolean[n];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a[s].add(e);
			a[e].add(s);
		}
		
		arrive = false;
		for (int i=0; i<n; i++) {
			DFS(i ,1); // 처음 ,depth
			if (arrive) {
				break;
			}
		}
		
		if (arrive) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}
	
	private static void DFS(int num, int depth) {
		if (depth==5 || arrive) {
			arrive = true;
			return;
		}
		
		v[num] = true;
		
		for (int i: a[num]) {
			if (!v[i]) {
				DFS(i, depth+1);
			}
		}
		
		v[num] = false;
		
		
		
		
		
		
		
		
	}
	

}
