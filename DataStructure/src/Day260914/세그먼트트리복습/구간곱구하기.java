package Day260914.세그먼트트리복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간곱구하기 {
	static int[] tree;
	static int MOD;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int length = n;
		int treeHeight = 0;
		
		while (length >0) {
			length /= 2;
			treeHeight++;
		}
		
		int treeSize = (int) Math.pow(2, treeHeight + 1);
		int leftNodeStartIdx = treeSize / 2 - 1;
		MOD = 1000000007;
		tree = new int[treeSize];
		
		for (int i=0; i < tree.length; i++) {
			tree[i] = 1;
		}
		
		for (int i=leftNodeStartIdx+1; i<=leftNodeStartIdx+n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		setTree(treeSize - 1);
		
		for (int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				changeVal(s+leftNodeStartIdx, e);
			}
			else if(a==2) {
				System.out.println(getMul(s+leftNodeStartIdx, e+leftNodeStartIdx));
			}
			
		}
		
	}
	
	private static void changeVal(int idx, int val) {
		tree[idx] = val;
		
		while (idx > 1) {
			idx /= 2;
			tree[idx] = tree[idx * 2] % MOD * tree[idx * 2 + 1] % MOD;
		}
	}
	
	private static int getMul(int s, int e) {
		int partMul = 1;
		
		while (s<=e) {
			if(s % 2 == 1) {
				partMul *= tree[s] % MOD;
				s++;
			}
			if (e % 2 == 0) {
				partMul *= tree[e] % MOD;
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return partMul;
	}
	
	private static void setTree(int idx) {
		while (idx > 1) {
			tree[idx / 2] = tree[idx / 2] * tree[idx] % MOD;
			idx--;
		}
	}
}
