package Day260819.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전개수의최솟값구하기_그리디복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 동전 수
		int price = Integer.parseInt(st.nextToken()); // 목표금액
		int[] a = new int[n];
		int count = 0;
		

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] <= price) {
				count += price / a[i];
				price = price % a[i];
			}
		}
		
		System.out.println(count);
	}

}
