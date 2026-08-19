package Day260819.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정하기_그리디복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][2];
		//저장
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				// 끝나는 시간 같을 때 일찍 시작하는 시간 먼저 나오게 왜냐면 앞에서부터 검사(시작시간 빠른 게)
				if (start[1] == end[1]) {
					return start[0] - end[0];
				}
				// 기본적으로 끝나는 시간 비교
				return start[1] - end[1];
			}
		});
		int count = 0;
		int end = -1;
		
		for (int i = 0; i < n; i++) {
			if (a[i][0] >= end) {
				end = a[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}
