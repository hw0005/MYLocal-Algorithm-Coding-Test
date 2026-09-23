package Day260923.동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장길게증가하는부분수열찾기 {
	static int n, maxLength;
	static int[] d = new int[1000001];
	static int[] a = new int[1000001];
	static int[] b = new int[1000001];
	static int[] ans = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx;
		b[++maxLength] = a[1];
		d[1] = 1;
		
		for (int i=2; i<=n; i++) {
			if (b[maxLength] < a[i]) {
				b[++maxLength] = a[i];
				d[i] = maxLength;
			}
			else {
				idx = binarysearch(1, maxLength, a[i]);
				b[idx] = a[i];
				d[i] = idx;
			}
		}
		System.out.println(maxLength);
		idx = maxLength;
		int x = b[maxLength] + 1;
		for (int i=n; i>=1; i--) {
			if(d[i] == idx && a[i] < x) {
				ans[idx] = a[i];
				x = a[i];
				idx--;
			}
		}
		for (int i=1; i<= maxLength; i++) {
			System.out.print(ans[i] + " ");
		}
		
	}
	public static int binarysearch(int l, int r, int now) {
		int mid;
		while (l<r) {
			mid = (l+r) / 2;
			if (b[mid] < now) {
				l = mid + 1;
			}
			else {
				r = mid;
			}
			
		}
		return l;
	}

}
