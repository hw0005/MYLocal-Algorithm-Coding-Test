package Day260917.세그먼트트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기3 {
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 변경횟수
		int k = Integer.parseInt(st.nextToken()); // 구간합횟수
		
		int treeHeight = 0;
		int length = n;
		while (length > 0) {
			length /= 2;
			treeHeight++;
		}
		
		int treeSize = (int) Math.pow(2, treeHeight + 1);
		int leftNodeStartIdx = treeSize / 2 - 1;
		tree = new int[treeSize];
		for (int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		setTree(treeSize - 1);
		
		for (int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if (a==1) {
				changeVal(s+leftNodeStartIdx, e);
			}
			else if(a==2) {
				System.out.println(getSum(s+leftNodeStartIdx, e+leftNodeStartIdx));
			}
			else {
				return;
			}
		}
	}
	
	private static int getSum(int s, int e) {
		int partSum = 0;
		while (s<=e) {
			if (s%2==1) {
				partSum += tree[s];
				s++;
			}
			if (e%2==0) {
				partSum += tree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return partSum;
	}
	
	
	private static void changeVal(int i, int val) {
		tree[i] = val;
		while (i > 0) {
			i /= 2;
			tree[i] = tree[i*2] + tree[i*2+1];
		}
	}
	
	private static void setTree(int i) {
		while (i > 1) {
			tree[i/2] += tree[i];
			i--;
		}
	}

}
