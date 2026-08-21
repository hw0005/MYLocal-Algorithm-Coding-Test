package Day260821.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거의소수_소수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		// 담을 배열 c
		long [] a = new long[10000001];
		
		//저장
		for (int i = 2; i < a.length; i++) {
			a[i] = i;
		}
		
		for (int i = 2; i <= Math.sqrt(a.length); i++) { // 제곱근까지만
			if (a[i] == 0) { // 배수여서 0으로 제거된 거면
				continue;
			}
			for (int j = i + i; j < a.length; j += i) { // i의 배수들 싹 다 제거
				a[j] = 0;
			}
		}
		int count = 0;
		// 1~ 1000 범위라면 그에 맞게 출력 함. 근데 여기서 이제 저장된 것들의 개수를 count 해야됨.
		for (int i = 2; i < a.length; i++) {
			if (a[i] != 0) {
				long temp = a[i]; // 증가할 것 근데 2 * 2즉 a[i] * a[i]부터시작 이후 temp * a[i] 
				while (a[i] <= max / temp) { // 이항처리
					if (a[i] >= min / temp) {
						count++;
					}
					temp = temp * a[i];
				}
			}
		}
		System.out.println(count);
		
		
	}

}
