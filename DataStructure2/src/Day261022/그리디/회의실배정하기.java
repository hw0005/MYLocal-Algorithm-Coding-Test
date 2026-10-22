package Day261022.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			a[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}

		// 1. 종료 시간 오름차순, 같으면 시작 시간 오름차순 정렬
		Arrays.sort(a, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] > o2[0] ? 1: -1; // 시작 시간 빠른 순
			}
			return o1[1] > o2[1] ? 1 : -1; // 종료 시간 빠른 순
		});

		// 2. 그리디 탐색
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
