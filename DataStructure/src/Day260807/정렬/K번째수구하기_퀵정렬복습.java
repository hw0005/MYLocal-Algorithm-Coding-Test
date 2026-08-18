package Day260807.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수구하기_퀵정렬복습 {
	public static void main(String[] args) throws IOException {
		// 입력 받을수 n, 찾을 수 k
		// 1. quickSort(a, s, e, k) pivot == k라면 찾은 거고 아니라면 재귀로 돌려
			// 1-1. partition함수 정의(a, s, e)
		// 2. partition함수
			// 2-1.알고리즘 만들기
		// 3. swap함수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // n개 받기
		int k = Integer.parseInt(st.nextToken()); // k번째 수 찾기
		
		// 담을 배열 생성 후 담기
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(a, 0, n - 1, k - 1);
		// 출력값 컴퓨터는 0부터 시작이기 때문에
		System.out.println(a[k-1]);
	} // main 끝
	
	private static void quickSort(int[] a, int s, int e, int k) {
		int pivot = partition(a, s, e);
		
		if (pivot == k) {
			return;
		}
		else if (pivot < k) {
			quickSort(a, s, pivot - 1, k);
		}
		else {
			quickSort(a, pivot + 1, e, k);
		}
	} // quickSort끝
	
	
	// partition: 핵심로직
	
	private static int partition(int a[], int s, int e) {
		// 2개 남았을 때부터
		if (s + 1 == e) {
			// 2개 남았는데, 클 때
			if (a[s] > a[e]) {
				swap(a, s, e);
			}
			return e;
		}
		
		
		// 중앙값과 처음 값 바꾸기. 중앙값= 처음값, 처음값=피봇(피신해있기)
		int m = (s + e) / 2;
		swap(a, s, m);
		
		// while i <= j ---> i: s+1, j==e -> 포인터 선언'
		int pivot = a[s];
		int i = s + 1;
		int j = e;
		
		// 찾으면서 마지막 값 포인터 카르켜
		while(i <= j) {
			while (i <= j && pivot > a[i]) {
				i++;
			}
			while (i <= j && pivot < a[j]) {
				j--;
			}
			// i <= j가 유지되면 swap실행. 실행 후 다음 포인터 가르켜
			if (i <= j) {
				swap(a, i++, j--);
			}
		}
		
		
		// i<=j가 꺠진 상태 
		// i: 큰 그룹의 최솟값, j: 작은그룹의 최댓값
		// 지금 피봇= a[s] -> j로 가야함 경계선
		// 내가 해야 할 것 : a[s](0번째) = j, a[j] = pivot(a[s])
		// 그리고 j return
		a[s] = a[j];
		a[j] = pivot;
		return j;
	} // partition 끝
	
	private static void swap(int[] a, int s, int e) {
		int temp = a[s];
		a[s] = a[e];
		a[e] = temp;
	} // swap 끝
}
