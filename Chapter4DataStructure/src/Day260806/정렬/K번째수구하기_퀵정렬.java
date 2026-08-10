package Day260806.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수구하기_퀵정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 데이터 개수 n, 찾는 것 k번째 수
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 배열에 담기
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			int request = Integer.parseInt(st.nextToken());
			a[i] = request;
		}
		
		// 퀵정렬
		quickSort(a, 0, n - 1, k - 1);
		System.out.println(a[k - 1]);
	} // main 끝
	
	// 퀵 정렬
	private static void quickSort(int[] a, int s, int e, int k) {
		if (s < e) {
			int pivot = partition(a, s, e);
			
			if (pivot == k) { // 같으면 그게 피봇임 return
				return;
			}
			else if (k < pivot) { // k가 작은 곳에 있음 작은 왼쪽그룹만 정렬하기
				quickSort(a, s, pivot - 1, k);
			}
			else { // k가 큰 곳에 있음 큰 오른쪽 그룹만 정렬하기
				quickSort(a, pivot + 1, e, k);
			}
		}
	} // quickSort 끝
	
	
	// 피봇 구하기 함수
	private static int partition (int[] a, int s, int e) {
		if (s + 1 == e) { // 데이터 2개라면 
			if (a[s] > a[e]) { // 데이터 2개밖에 없는데, 앞의 값이 더 크면 바꿔
				swap(a, s, e);
			}
			return e; // 데이터 2개인데 a[s] < a[e]면 유지해 그래서 e 보내
		}
		
		int m = (s + e) / 2;
		swap (a, s, m); // 중앙값과 1번째값 swap
		
		
		int pivot = a[s]; // 피봇값 바꿔서 a[s]가 중앙 이동
		int i = s + 1; // i는 지금 원래 start였던 그다음부터 설정
		int j = e; // j는 끝 설정
		
		
		while (i <= j) { // j를 땡기는데 i를 만날 때까지 반복
			while (j >= s + 1 && pivot < a[j]) { // 피봇보다 작은 수가 나올 떄까지
				j--;
			}
			while (i <= e && pivot > a[i]) { // 피봇보다 큰 수가 나올 때까지
				i++;
			}
			if (i <= j) {
				swap(a, i++, j--);
			}
		}
		
		// 피봇 데이터를 나눠진 두 그룹의 경계 index에 저장
		a[s] = a[j];
		a[j] = pivot;
		return j;
	} // partition 끝
	
	private static void swap (int[] a, int s, int e) {
		int temp = a[s];
		a[s] = a[e];
		a[e] = temp;
	} // swap 끝

}
