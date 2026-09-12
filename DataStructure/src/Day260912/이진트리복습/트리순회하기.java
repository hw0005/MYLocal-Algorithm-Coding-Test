package Day260912.이진트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리순회하기 {
	static int[][] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 노드 수
		
		tree = new int[26][2];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node = st.nextToken().charAt(0) - 'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if (left == '.') {
				tree[node][0] = -1;
			}
			else {
				tree[node][0] = left - 'A';
			}
			
			if (right == '.') {
				tree[node][1] = -1;
			}
			else {
				tree[node][1] = right - 'A';
			}
		}
		
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
		

	}
	private static void preOrder(int num) {
		if (num == -1) {
			return;
		}
		System.out.print((char) (num + 'A'));
		preOrder(tree[num][0]);
		preOrder(tree[num][1]);
	}
	
	private static void inOrder(int num) {
		if (num == -1) {
			return;
		}
		inOrder(tree[num][0]);
		System.out.print((char) (num + 'A'));
		inOrder(tree[num][1]);
	}
	
	private static void postOrder(int num) {
		if (num == -1) {
			return;
		}
		postOrder(tree[num][0]);
		postOrder(tree[num][1]);
		System.out.print((char) (num + 'A'));
	}

}
