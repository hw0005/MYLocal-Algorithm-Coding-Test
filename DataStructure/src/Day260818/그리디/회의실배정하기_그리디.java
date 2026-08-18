package Day260818.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정하기_그리디 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][2];
		
		for (int i = 0; i< n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] s, int[] e) {
				if (s[1] == e[1]) {
					return s[0] - e[0];
				}
				return s[1] - e[1];
			}
		});
		int count = 0;
		int end = -1;
		
		for(int i = 0; i < n; i++) {
			if (a[i][0] >= end) { // 시작 시간이 종료시간 보다 크면
				end = a[i][1]; // 종료시간 = 시작시간의 종료시간으로 설정
				count++;
			}
		}
		System.out.println(count + "개");
		
	}

}
