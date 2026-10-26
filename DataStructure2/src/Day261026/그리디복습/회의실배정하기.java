package Day261026.그리디복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 회의 개수
		int[][] a = new int[n][2];
		
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int count = 0;
		int end = -1;
		
		for (int i=0; i<n; i++) {
			if(a[i][0] >= end) {
				end = a[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
