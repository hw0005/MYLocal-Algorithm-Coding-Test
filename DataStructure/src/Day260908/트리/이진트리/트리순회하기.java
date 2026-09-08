package Day260908.트리.이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회하기 {
	static int[][] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new int[26][2];
		
		for (int i=0; i<n; i++) {
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
	
	public static void preOrder(int number) {
		if (number == -1) {
			return;
		}
		System.out.print((char) (number + 'A'));
		preOrder(tree[number][0]);
		preOrder(tree[number][1]);
		
	}
	public static void inOrder(int number) {
		if (number == -1) {
			return;
		}
		inOrder(tree[number][0]);
		System.out.print((char) (number + 'A'));
		inOrder(tree[number][1]);
	}
	public static void postOrder(int number) {
		if (number == -1) {
			return;
		}
		postOrder(tree[number][0]);
		postOrder(tree[number][1]);
		System.out.print((char) (number + 'A'));
	}
	


}
