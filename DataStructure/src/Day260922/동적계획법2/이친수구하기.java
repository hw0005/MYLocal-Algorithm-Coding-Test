package Day260922.동적계획법2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 우선 해 -> 0으로 시작 X, 1이 두번 연속 X
//		
//		long[] d = new long[n+1];
//		
//		d[1]=1;
//		d[2]=1;
//		for (int i=3; i<=n; i++) {
//			d[i] = d[i-1] + d[i-2];
//		}
//		
//		System.out.println(d[n]);
		
		
		// or
		
		long[][] d = new long[n+1][2];
		d[1][1] = 1;
		d[1][0] = 0;
		
		for (int i=2; i<=n; i++) {
			d[i][0] = d[i-1][1] + d[i-1][0];
			d[i][1] = d[i-1][0];	
		}
		System.out.println(d[n][0] + d[n][1]);
	}

}
