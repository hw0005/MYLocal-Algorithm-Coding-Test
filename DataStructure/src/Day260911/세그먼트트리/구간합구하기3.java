package Day260911.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 구간합구하기3 {

	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 변경횟수
		int k = Integer.parseInt(st.nextToken()); // 구간 합 횟수
		
		int treeheight = 0;
		int length = n;
		
		while (length != 0) {
			length /= 2;
			treeheight++;
		}
		
		int treeSize = (int) Math.pow(2, treeheight + 1); // 16
		int leftNodeStartIdx = treeSize / 2 - 1; // 7
		tree = new int[treeSize + 1];
		
		
		for (int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		setTree(treeSize - 1);
		
		
		for (int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				changeVal(b+leftNodeStartIdx, c);
			}
			else if(a==2) {
				b = b + leftNodeStartIdx;
				c = c + leftNodeStartIdx;
				System.out.println(getSum(b, c));
			}
			
			
			
		}
			
		
		
	}
	
	private static int getSum(int s, int e) {
		int partSum = 0;
		while (s<=e) {
			if(s % 2 == 1) {
				partSum += tree[s];
				s++;
			}
			if (e % 2 ==0) {
				partSum += tree[e];
				e--;
			}
			s = s / 2;
			e = e / 2;
		}
		return partSum;
	}
	
	private static void changeVal(int idx, int val) {
		int diff = val - tree[idx];
		
		while (idx > 0) {
			tree[idx] += diff;
			idx /= 2;
		}
		
	}
	
	private static void setTree(int i) {
		while (i != 1) {
			tree[i/2] += tree[i];
			i--;
		}
	}
	



}
