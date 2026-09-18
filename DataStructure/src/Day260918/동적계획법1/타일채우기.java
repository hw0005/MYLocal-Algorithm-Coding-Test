package Day260918.동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타일채우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[n+1];
		d[1] = 1;
		d[2] = 2;
		
		for (int i=3; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		
		System.out.println(d[n]);
		
		
		
	}

}
