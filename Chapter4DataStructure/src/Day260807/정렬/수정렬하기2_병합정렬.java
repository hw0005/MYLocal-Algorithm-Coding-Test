package Day260807.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기2_병합정렬 {
	static int[] a, tmp;
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		// 담을 배열 선언 후 담기
		a = new int[n];
		tmp = new int[n];
		
		for (int i = 0 ; i < a.length; i++) {
			a[i]  = Integer.parseInt(br.readLine());
		}
		
		// 병합 정렬
		mergeSort(0, n - 1);
		
		// 출력하기
		for (int i = 0; i < a.length; i++) {
			bw.write(a[i] + "\n");
		}
		bw.flush();
		bw.close();
	} // main 끝
	
	private static void mergeSort(int s, int e) {
		// 시작점 s, 중간점 m, 종료점 e
		
		if (e - s < 1) { // 더이상 쪼갤 게 없다면
			return;
		}
		
		int m = s + (e - s) / 2;
		
		//재귀함수 형태 -> mergeSort 나누기
		mergeSort(s, m); // 앞부터 중간
		mergeSort(m + 1, e); // 중간 + 1 부터 뒤
		
		for (int i = s; i <= e; i++) {
			tmp[i] = a[i];
		}
		int k = s; // s == k 실제 a배열 안에 있는 인덱스 표시 용
		int idx1 = s;
		int idx2 = m + 1;
		
		// 두 그룹 병합 로직, 양쪽 그룹 index가 가리키는 값 비교해 더 작은 수 선택 후 배열 저장. 그 후 오른 쪽 이동
		while (idx1 <= m && idx2 <= e) { 
			if (tmp[idx1] > tmp[idx2]) {
				a[k] = tmp[idx2];
				idx2++;
				k++;
			}
			else {
				a[k] = tmp[idx1];
				idx1++;
				k++;
			}
		}
		
		// 한쪽 그룹 정리하기
		while (idx1 <= m)  {
			a[k] = tmp[idx1];
			idx1++;
			k++;
		}
		while (idx2 <= e) {
			a[k] = tmp[idx2];
			idx2++;
			k++;
		}
	}
}
