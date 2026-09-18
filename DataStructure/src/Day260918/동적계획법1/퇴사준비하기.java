package Day260918.동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사준비하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[n+2];
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=n; i>0; i--) {
			if(i + t[i] > n+1) { // i번째 상담을 퇴사일까지 끝낼 수 없을 때
				d[i] = d[i+1];
			}
			else {
				d[i] = Math.max(d[i+1], p[i] + d[i + t[i]]);
			}
		
		}
		System.out.println(d[1]);
		
		
	}

}
