package Day260818.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블루레이만들기_BS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 초기화
		int n = Integer.parseInt(st.nextToken()); // 레슨 수
		int m = Integer.parseInt(st.nextToken()); // 블루레이 개수
		int[] a = new int[n];
		int start = 0;
		int end = 0;

		// 값 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if (start < a[i]) { // a[i]중 제일 큰 것을 최솟값
				start = a[i];
			}
			end += a[i]; // 누적 최댓값
		}

		// 블루레이 확인하는 while, for문
		while (start <= end) {
			int middle = start + (end - start) / 2;
			int sum = 0;
			int count = 0; // 블루레이 개수 세기
			
			for (int i = 0; i < n; i++) {
				if (sum + a[i] > middle) { // 중앙값보다 크면 블루레이 1개 차지함
					count++; // 하나 올려
					sum = 0;
				}
				sum += a[i];
			}

			if (sum != 0) { // 홀로 남겨진 숫자 하나겠지 아마도?
				count++;
			}
			if (count > m) { // 블루레이 조건 만족 안됨
				start = middle + 1;
			}
			else { // 만족 시
				end = middle - 1;
			}
		}
		System.out.println(start);

	}
}
