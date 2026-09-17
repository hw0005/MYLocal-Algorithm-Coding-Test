package Day260917.세그먼트트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값찾기2 {
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 질의 수
		
		int treeHeight = 0;
		int length = n;
		
		while (length > 0) {
			length /= 2;
			treeHeight++;
		}
		
		int treeSize = (int) Math.pow(2, treeHeight + 1);
		int leftNodeStartIdx = treeSize / 2 - 1;
		tree = new int[treeSize];
		
		for (int i=1; i<tree.length; i++) {
			tree[i] = Integer.MAX_VALUE;
		}
		
		for (int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		setTree(treeSize - 1);
		
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			System.out.println(getMin(s+leftNodeStartIdx, e+leftNodeStartIdx));
		}
	}
	
	private static int getMin(int s, int e) {
		int min = Integer.MAX_VALUE;
		
		while (s<=e) {
			if (s%2==1) {
				min = Math.min(min, tree[s]);
				s++;
			}
			if (e%2==0) {
				min = Math.min(min, tree[e]);
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return min;
	}
	
	private static void setTree(int i) {
		while (i > 1) {
			if (tree[i/2] > tree[i]) {
				tree[i/2] = tree[i];
			}
			i--;
		}
	}

}
