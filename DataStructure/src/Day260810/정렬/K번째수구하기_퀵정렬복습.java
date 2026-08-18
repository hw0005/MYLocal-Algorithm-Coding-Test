package Day260810.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수구하기_퀵정렬복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 데이터 개수 n
		int k = Integer.parseInt(st.nextToken()); // 구할 수 k
		
		//배열 선언 후 담기
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(a, 0, n - 1, k-1);
		
		// 출력
		System.out.println(a[k - 1]);
		
		
	}
	
	private static void quickSort (int[] a, int s, int e, int k) {
		int pivot = partition(a, s, e);
		
		if (pivot == k) {
			return;
		}
		else if (pivot > k) {
			partition(a, s, pivot);
		}
		else {
			partition(a, pivot + 1, e);
		}
		
	}
	
	
	private static int partition(int[] a, int s, int e) {
		// 2개만 있을 떄 
		if (s + 1 == e) {
			if (a[s] > a[e]) { // 2개만 있는데 앞에 있는 게 클 때
				swap(a, s, e);
			}
		}
		
		// 중앙값과 처음값 swap
		int m = s + ((e - s) / 2);
		swap (a, s, m);
		
		int pivot = a[s];
		int i = s + 1;
		int j = e;
		
		while(i <= j) {
			while (j >= s + 1 && pivot > a[i]) {
				i++;
			}
			while (i <= e && pivot < a[j]) {
				j--;
			}
			if (i <= j) {
				swap(a, i++, j--);
			}
		}
		
		// 피봇은 j, a[s]는 a[j]값;
		pivot = a[j];
		a[s] = a[j];
		return j;
	}
	
	private static void swap(int[] a, int s, int e) {
		int temp = a[s];
		a[s] = a[e];
		a[e] = a[s];
	}
	
	
	
	
	
	
	
	
	
	
	

}
