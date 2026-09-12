package Day260912.세그먼트트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값찾기2 {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드수 
		int m = Integer.parseInt(st.nextToken()); // 질의 수
		
		int length = n;
		int treeheight = 0;
		while (length > 0) {
			length /= 2;
			treeheight++;
		}
		
		int treeSize = (int) Math.pow(2, treeheight + 1);
		int leftNodeStartIdx = treeSize / 2 - 1;
		
		tree = new long[treeSize];
		for (int i=0; i < tree.length; i++) {
			tree[i] = Long.MAX_VALUE;
		}
		for (int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+n; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		
		setTree(treeSize - 1);
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			System.out.println(getMin(s+leftNodeStartIdx, e+leftNodeStartIdx));
		}
		
		
	}
	
	private static long getMin(int s, int e) {
		long min = Long.MAX_VALUE;
		
		while (s<=e) {
			if (s % 2 == 1) {
				min = Math.min(tree[s], min);
				s++;
			}
			if (e % 2 == 0) {
				min = Math.min(tree[e], min);
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return min;
	}
	
	private static void setTree(int i) {
		while (i != 1) {
			if (tree[i/2] > tree[i]) {
				tree[i/2] = tree[i];
			}
			i--;
		}
	}

}
