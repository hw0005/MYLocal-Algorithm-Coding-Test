package Day261002.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); // 데이터 수
		int m = Integer.parseInt(st.nextToken()); // 질의 수
		
		int[] arr = new int[n+1];
		int[] sumArr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sumArr[1] = arr[1];
		
		for (int i=2; i<sumArr.length; i++) {
			sumArr[i] = sumArr[i-1] + arr[i];
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(sumArr[e] - sumArr[s-1] + "\n");
		}
		
		System.out.println(sb);
		
	}

}
