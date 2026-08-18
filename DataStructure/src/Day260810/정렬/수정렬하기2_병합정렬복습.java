package Day260810.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기2_병합정렬복습 {
	static int[] a, tmp;
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); // 데이터개수 n
		
		// 배열 선언 후 저장하기
		a = new int[n];
		tmp = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(br.readLine()); // 한 줄씩 데이터 넣고 저장하기
		}
		
		mergeSort(0, n - 1);
		
		for (int i = 0; i < a.length; i++) {
			bw.write(a[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void mergeSort(int s, int e) {
		if (e - s < 1) {
			return;
		}
		
		int m = s + ((e - s) / 2);
		
		mergeSort(s, m);
		mergeSort(m + 1, e);
		
		// tmp에 저장
		for (int i = s; i <= e; i++) {
			tmp[i] = a[i];
		}
		
		// tmp로 돌면서 a에 저장할 변수 생성
		int k = s;
		int idx1 = s;
		int idx2 = m + 1;
		
		
		// 분할 정복 로직
		while (idx1 <= m && idx2 <= e) {
			if (tmp[idx1] > tmp[idx2]) {
				a[k] = tmp[idx2];
				idx2++;
				k++;
			}
			else if (tmp[idx1] < tmp[idx2]) {
				a[k] = tmp[idx1];
				idx1++;
				k++;
			}
		}
		
		// 어느 한 쪽 그룹의 정렬 안 된 것 처리
		while (idx1 <= m) {
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
