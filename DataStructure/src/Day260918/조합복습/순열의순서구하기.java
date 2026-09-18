package Day260918.조합복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열의순서구하기 {
	static int[] f;
	static int[] s;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		f = new int[n+1];
		s = new int[n+1];
		visited = new boolean[n+1];
		
		f[0] = 1;
		for (int i=1; i<=n; i++) {
			f[i] = f[i-1] * i;
		}
		
		st = new StringTokenizer(br.readLine());
		
		int q = Integer.parseInt(st.nextToken());
		
		if (q==1) {
			int k = Integer.parseInt(st.nextToken());
			
			for (int i=1; i<=n; i++) {
				for (int j=1, cnt=1; j<=n; j++) {
					if (visited[j]) {
						continue;
					}
					if (k <= cnt * f[n-i]) {
						k -= (cnt-1) * f[n-i];
						visited[j] = true;
						s[i] = j;
						break;
					}
					cnt++;
				}
			}
			for (int i=1; i<=n; i++) {
				System.out.print(s[i] + " ");
			}
		}
		else {
			int k = 1;
			
			for (int i=1; i<=n; i++) {
				s[i] = Integer.parseInt(st.nextToken());
				int cnt = 0;
				for (int j=1; j<s[i]; j++) {
					if (!visited[j]) {
						cnt++;
					}
				}
				k += cnt * f[n-i];
				visited[s[i]] = true;
			}
			System.out.println(k);
		}
		
		
		
	}

}
