package Day260804.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의명령 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 재료 개수
		int m = Integer.parseInt(br.readLine()); // 갑옷 번호 합
		
		int[] a = new int[n]; // 재료 담을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		int endIdx = n - 1; // 끝 인덱스, max
		int startIdx = 0; // 시작 인덱스, min
		int count = 0;
		
		while (startIdx < endIdx) {
			if (a[endIdx] + a[startIdx] == m) {
				count++;
				endIdx--;
				startIdx++;
			}
			else if (a[endIdx] + a[startIdx] < m) {
				startIdx++;
			}
			else {
				endIdx--;
			}
		}
		
		System.out.println(count);
		
		
	}

}
