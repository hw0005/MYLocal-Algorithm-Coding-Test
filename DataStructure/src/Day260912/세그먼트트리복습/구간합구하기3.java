package Day260912.세그먼트트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기3 {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 변경 수
		int k = Integer.parseInt(st.nextToken()); // 구간 합 수
		
		int length = n;
		int treeheight = 0;
		
		while (length > 0) {
			length /= 2;
			treeheight++;
		}
		
		int treeSize = (int) Math.pow(2, treeheight + 1);
		int leftNodeStartIdx = treeSize / 2 - 1;
		
		tree = new long[treeSize];
		for (int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+n; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		setTree(treeSize - 1);
		
		for (int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if (a==1) {
				changeVal(leftNodeStartIdx+s, e);
			}
			else if (a==2) {
				s = s + leftNodeStartIdx;
				e = e + leftNodeStartIdx;
				System.out.println(getSum(s, e));
			}
		}
		
		
	
	}
	
	private static void changeVal(int idx, int val) {
		tree[idx] = val;
		
		while (idx > 1) {
			idx /= 2;
			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
		}
	}
	
	private static long getSum(int s, int e) {
		long partSum = 0;
		
		while (s<=e) {
			if (s % 2 == 1) {
				partSum += tree[s];
				s++;
			}
			if (e % 2 == 0) {
				partSum += tree[e];
				e--;
			}
			s /= 2;
			e /= 2;
		}
		
		return partSum;
	}
	
	
	private static void setTree (int idx) {
		while(idx > 1) {
			tree[idx/2] += tree[idx];
			idx--;
		}
	}

}
