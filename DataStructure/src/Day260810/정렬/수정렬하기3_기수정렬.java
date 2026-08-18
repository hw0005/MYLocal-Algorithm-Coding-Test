package Day260810.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기3_기수정렬 {
	static int[] a;
	static long reuslt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		radixSort(a, 5);
		
		for (int i = 0; i < a.length; i++) {
			bw.write(a[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	
	private static void radixSort(int[] a, int maxSize) {
		// bucket: 0~9담을 배열, output: 자릿수마다 최종적으로 담을 a정렬된 배열. 끝나고 a에 넣기
		int[] output = new int[a.length];
		
		// count: 몇 번 했는지(자릿수). jarisu: 일의자리부터 시작
		int jarisu = 1;
		int count = 0;
		
		while (count != maxSize) {
			int[] bucket = new int[10];
			
			// 1. 일의 자리 세기
			for (int i = 0; i< a.length; i++) {
				bucket[(a[i] / jarisu) % 10]++;
			}
			
			// 2. 합배열로 범위 지정
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i-1];
			}
			
			// 3. 범위 지정된 거 output배열에 자리지정
			for (int i = a.length - 1; i >= 0; i--) {
				output[bucket[(a[i] / jarisu) % 10] - 1] = a[i];
				bucket[(a[i] / jarisu) % 10]--;
			}
			
			// 4. 저장
			for (int i = 0; i< a.length; i++) {
				a[i] = output[i];
			}
			jarisu *= 10;
			count++;
		}
	}
}
