package Day260819.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_그리디복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 카드 묶음 수
		
		// d1 + d2 합 저장 후 d1+d2한 걸 저장 -> queue
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int sum = 0;
		// 데이터 저장
		for (int i = 0; i < n; i++) {
			int data = Integer.parseInt(br.readLine());
			pq.offer(data);
		}
		// 합 구하기
		while (pq.size() != 1) {
			int data1 = pq.poll();
			int data2 = pq.poll();
			sum += data1 + data2;
			pq.offer(data1 + data2);
		}
		System.out.println(sum);

	}

}
