package 그래프.Day261027.그리디복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 회의실 개수
		
		int[][] a = new int[n][2];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a[i][0] = s;
			a[i][1] = e;
		}
		
		Arrays.sort(a, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int count = 0;
		int end = -1;
		
		for (int i=0; i<a.length; i++) {
			if (a[i][0] > end) {
				end = a[i][1];
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
