package Day260911.세그먼트트리;

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
		
		int n = Integer.parseInt(st.nextToken()); //노드수
		int m = Integer.parseInt(st.nextToken());//변경수
		int k = Integer.parseInt(st.nextToken());//구간곱횟수
		
		
		int treeheight = 0;
		int length = n;
		while (length > 0) {
			length /= 2;
			treeheight++;
		}
		
		int treeSize = (int) Math.pow(2, treeheight + 1);
		int leftNodeFirstIdx = treeSize / 2 - 1;
		MOD = 1000000007;
		
		tree = new int[treeSize + 1];
		
		for (int i=0; i<tree.length; i++) {
			tree[i] = 1;
		}
		
		for (int i=leftNodeFirstIdx+1; i<=leftNodeFirstIdx+n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		setTree(treeSize - 1);
		for (int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (a==1) {
				changeVal(leftNodeFirstIdx+s, e);
			}
			else if(a==2) {
				s = s + leftNodeFirstIdx;
				e = e + leftNodeFirstIdx;
				System.out.println(getMul(s, e));
			}
			
		}
		
		
		
	}
	
	private static int getMul(int s, int e) {
		int partMul = 1;
		while(s<=e) {
			if(s % 2 == 1) {
				partMul = partMul * tree[s] % MOD;
				s++;
			}
			if (e % 2== 0) {
				partMul = partMul * tree[e] % MOD;
				e--;
			}
			s /= 2;
			e /= 2;
		}
		return partMul;
	}
	
	private static void changeVal(int idx, int val) {
		tree[idx] = val;
		
		while (idx > 1) {
			idx = idx / 2;
			tree[idx] = tree[idx * 2] % MOD * tree[idx*2 +1] % MOD;
		}
		
	}
	
	private static void setTree(int i) {
		while (i != 1) {
			tree[i/2] = tree[i/2] * tree[i] % MOD;
			i--;
		}
	}
}
