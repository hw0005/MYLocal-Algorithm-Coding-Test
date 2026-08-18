package Day260818.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전개수의최솟값구하기_그리디 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 변수선언 1
		int n = Integer.parseInt(st.nextToken()); // 동전수
		int k = Integer.parseInt(st.nextToken()); // 목표 금액
		int[] a = new int[n]; // 담을 배열
		
		// 값 저장
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		// 변수선언 2
		int count = 0;
		
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] <= k) { // 지금 돌고있는 동전이 목표금액(k)보다 작을 때만
				count += k / a[i];
				k = k % a[i];
			}
		}
		System.out.println(count);
		
	}

}
