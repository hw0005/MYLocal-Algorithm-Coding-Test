import java.util.Scanner;

public class 평균구하기 {
	public static void main(String[] args) {
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		// 몇 개 받을지 스캐너로 받기
		int N = sc.nextInt();
		
		// 받은 것 A배열로 선언
		int[] A = new int[N];
		
		// A배열 for문 돌면서 저장
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		
		long sum = 0;
		long max = 0;
		
		for (int i = 0; i < N; i++) {
			if (A[i] > max) {
				max = A[i];
			}
			sum += A[i];
		}
		System.out.println(sum * 100.0/max/N);
		
	}

}
